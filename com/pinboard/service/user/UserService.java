// UserService.java
package com.pinboard.service.user;

import com.pinboard.dto.PinDTO;
import com.pinboard.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    List<UserDTO> searchUsers(String query);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    void deleteUser(Long id);
    UserDTO followUser(Long userId, Long followId);
    UserDTO unfollowUser(Long userId, Long followId);
    List<PinDTO> getUserFeed(Long userId);
    void subscribeToPin(Long userId, Long pinId);
    void unsubscribeFromPin(Long userId, Long pinId);
}