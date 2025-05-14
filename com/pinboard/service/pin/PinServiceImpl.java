// PinServiceImpl.java
package com.pinboard.service.pin;

import com.pinboard.dto.PinDTO;
import com.pinboard.model.Pin;
import com.pinboard.model.Tag;
import com.pinboard.model.User;
import com.pinboard.pattern.decorator.FeaturedPinDecorator;
import com.pinboard.pattern.decorator.PromotedPinDecorator;
import com.pinboard.pattern.factory.PinFactory;
import com.pinboard.pattern.factory.PinType;
import com.pinboard.pattern.observer.PinUpdateSubject;
import com.pinboard.pattern.strategy.PinSearchStrategy;
import com.pinboard.pattern.strategy.SearchStrategy;
import com.pinboard.repository.PinRepository;
import com.pinboard.repository.TagRepository;
import com.pinboard.repository.UserRepository;
import com.pinboard.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PinServiceImpl implements PinService {

    private final PinRepository pinRepository;
    private final UserRepository userRepository;
    private final TagRepository tagRepository;
    private final PinFactory pinFactory;
    private final PinUpdateSubject pinUpdateSubject;
    private final FileUploadUtil fileUploadUtil;
    private final SearchStrategy<Pin> pinSearchStrategy;

    @Autowired
    public PinServiceImpl(
            PinRepository pinRepository,
            UserRepository userRepository,
            TagRepository tagRepository,
            PinFactory pinFactory,
            PinUpdateSubject pinUpdateSubject,
            FileUploadUtil fileUploadUtil,
            PinSearchStrategy pinSearchStrategy) {
        this.pinRepository = pinRepository;
        this.userRepository = userRepository;
        this.tagRepository = tagRepository;
        this.pinFactory = pinFactory;
        this.pinUpdateSubject = pinUpdateSubject;
        this.fileUploadUtil = fileUploadUtil;
        this.pinSearchStrategy = pinSearchStrategy;
    }

    @Override
    public List<PinDTO> getAllPins() {
        return pinRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PinDTO getPinById(Long id) {
        Pin pin = pinRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + id));
        return convertToDTO(pin);
    }

    @Override
    public List<PinDTO> searchPins(String query) {
        List<Pin> pins = pinRepository.findAll();
        List<Pin> searchResults = pinSearchStrategy.search(pins, query);
        return searchResults.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PinDTO createPin(PinDTO pinDTO, PinType type) {
        User user = userRepository.findById(pinDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + pinDTO.getUserId()));
        
        Pin pin = pinFactory.createPin(type);
        pin.setTitle(pinDTO.getTitle());
        pin.setDescription(pinDTO.getDescription());
        pin.setImageUrl(pinDTO.getImageUrl());
        pin.setUser(user);
        
        Pin savedPin = pinRepository.save(pin);
        pinUpdateSubject.notifyObservers(savedPin);
        
        return convertToDTO(savedPin);
    }

    @Override
    @Transactional
    public PinDTO createPinWithImage(PinDTO pinDTO, PinType type, MultipartFile image) {
        String fileName = fileUploadUtil.saveFile(image);
        pinDTO.setImageUrl(fileName);
        return createPin(pinDTO, type);
    }

    @Override
    @Transactional
    public PinDTO updatePin(PinDTO pinDTO) {
        Pin pin = pinRepository.findById(pinDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + pinDTO.getId()));
        
        pin.setTitle(pinDTO.getTitle());
        pin.setDescription(pinDTO.getDescription());
        
        if (pinDTO.getImageUrl() != null) {
            pin.setImageUrl(pinDTO.getImageUrl());
        }
        
        Pin updatedPin = pinRepository.save(pin);
        pinUpdateSubject.notifyObservers(updatedPin);
        
        return convertToDTO(updatedPin);
    }

    @Override
    @Transactional
    public void deletePin(Long id) {
        if (!pinRepository.existsById(id)) {
            throw new EntityNotFoundException("Pin not found with id: " + id);
        }
        pinRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PinDTO promotePin(Long id) {
        Pin pin = pinRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + id));
        
        // Apply Decorator pattern
        pin.setPromoted(true);
        pin.setTitle("📢 " + pin.getTitle());
        pin.setDescription(pin.getDescription() + "\n\nThis is a promoted pin.");
        
        Pin savedPin = pinRepository.save(pin);
        return convertToDTO(savedPin);
    }

    @Override
    @Transactional
    public PinDTO featurePin(Long id) {
        Pin pin = pinRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + id));
        
        // Apply Decorator pattern
        pin.setFeatured(true);
        pin.setTitle("⭐ " + pin.getTitle());
        pin.setDescription(pin.getDescription() + "\n\nThis is a featured pin selected by our editors!");
        
        Pin savedPin = pinRepository.save(pin);
        return convertToDTO(savedPin);
    }

    @Override
    @Transactional
    public PinDTO addTagToPin(Long pinId, Long tagId) {
        Pin pin = pinRepository.findById(pinId)
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + pinId));
        
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found with id: " + tagId));
        
        pin.getTags().add(tag);
        Pin updatedPin = pinRepository.save(pin);
        return convertToDTO(updatedPin);
    }

    @Override
    @Transactional
    public PinDTO removeTagFromPin(Long pinId, Long tagId) {
        Pin pin = pinRepository.findById(pinId)
                .orElseThrow(() -> new EntityNotFoundException("Pin not found with id: " + pinId));
        
        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found with id: " + tagId));
        
        pin.getTags().remove(tag);
        Pin updatedPin = pinRepository.save(pin);
        return convertToDTO(updatedPin);
    }

    private PinDTO convertToDTO(Pin pin) {
        PinDTO dto = new PinDTO();
        dto.setId(pin.getId());
        dto.setTitle(pin.getTitle());
        dto.setDescription(pin.getDescription());
        dto.setImageUrl(pin.getImageUrl());
        dto.setUserId(pin.getUser().getId());
        
        if (pin.getTags() != null) {
            dto.setTagIds(pin.getTags().stream()
                .map(Tag::getId)
                .collect(Collectors.toList()));
        }
        
        dto.setFeatured(pin.isFeatured());
        dto.setPromoted(pin.isPromoted());
        dto.setType(pin.getType());
        dto.setViewCount(pin.getViewCount());
        
        return dto;
    }
}