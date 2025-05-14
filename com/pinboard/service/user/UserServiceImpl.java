// UserServiceImpl.java
package com.pinboard.service.user;

import com.pinboard.dto.PinDTO;
import com.pinboard.dto.UserDTO;
import com.pinboard.model.Pin;
import com.pinboard.model.User;
import com.pinboard.pattern.observer.UserPinObserver;
import com.pinboard.pattern.strategy.SearchStrategy;
import com.pinboard.repository.PinRepository;
import com.pinboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PinRepository pinRepository;
    private final SearchStrategy<User> userSearchStrategy;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            PinRepository pinRepository,
            SearchStrategy<User> userSearchStrategy) {
        this.userRepository = userRepository;
        this.pinRepository = pinRepository;
        this.userSearchStrategy = userSearchStrategy;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return convertToDTO(user);
    }

    @Override
    public List<UserDTO> searchUsers(String query) {
        List<User> users = userRepository.findAll();
        List<User> searchResults = userSearchStrategy.search(users, query);
        return searchResults.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword()); // Em uma aplicação real, deveria criptografar a senha
        
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    @Transactional
    public UserDTO updateUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userDTO.getId()));
        
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            user.setPassword(userDTO.getPassword()); // Em uma aplicação real, deveria criptografar a senha
        }
        
        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDTO followUser(Long userId, Long followId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        
        User followUser = userRepository.findById(followId)
                .orElseThrow(() -> new EntityNotFoundException("User to follow not found with id: " + followId));
        
        user.getFollowing().add(followUser);
        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }

    @Override
    @Transactional
    public UserDTO unfollowUser(Long userId, Long followId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        
        User followUser = userRepository.findById(followId)
                .orElseThrow(() -> new EntityNotFoundException("User to unfollow not found with id: " + followId));
        
        user.getFollowing().remove(followUser);
        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }

    @Override
    public List<PinDTO> getUserFeed(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        
        // Obter pins dos usuários que o usuário atual segue
        List<Long> followingIds = user.getFollowing().stream()
                .map(User::getId)
                .collect(Collectors.toList());
        
        List<Pin> feedPins = new ArrayList<>();
        for (Long followingId : followingIds) {
            feedPins.addAll(pinRepository.findByUserId(followingId));
        }
        
        return feedPins.stream()
                .map(pin -> {
                    PinDTO dto = new PinDTO();
                    dto.setId(pin.getId());
                    dto.setTitle(pin.getTitle());
                    dto.setDescription(pin.getDescription());
                    dto.setImageUrl(pin.getImageUrl());
                    dto.setUserId(pin.getUser().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void subscribeToPin(Long userId, Long pinId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        
        Pin pin = pinRepository.findById(pinId)
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + pinId));
        
        // Criar um novo observer para este usuário e pin
        UserPinObserver observer = new UserPinObserver(user);
        pin.getSubject().registerObserver(observer);
        
        pinRepository.save(pin);
    }

    @Override
    @Transactional
    public void unsubscribeFromPin(Long userId, Long pinId) {
        Pin pin = pinRepository.findById(pinId)
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + pinId));
        
        // Encontrar e remover o observer para este usuário
        pin.getSubject().getObservers().stream()
                .filter(obs -> obs instanceof UserPinObserver && 
                        ((UserPinObserver) obs).getUser() != null && 
                        ((UserPinObserver) obs).getUser().getId().equals(userId))
                .findFirst()
                .ifPresent(obs -> pin.getSubject().removeObserver(obs));
        
        pinRepository.save(pin);
    }

    private UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        // Não incluir a senha por questões de segurança
        
        if (user.getFollowing() != null) {
            dto.setFollowingIds(user.getFollowing().stream()
                    .map(User::getId)
                    .collect(Collectors.toList()));
        }
        
        if (user.getFollowers() != null) {
            dto.setFollowerIds(user.getFollowers().stream()
                    .map(User::getId)
                    .collect(Collectors.toList()));
        }
        
        return dto;
    }
}