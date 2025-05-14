// PinService.java
package com.pinboard.service.pin;

import com.pinboard.dto.PinDTO;
import com.pinboard.pattern.factory.PinType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PinService {
    List<PinDTO> getAllPins();
    PinDTO getPinById(Long id);
    List<PinDTO> searchPins(String query);
    PinDTO createPin(PinDTO pinDTO, PinType type);
    PinDTO createPinWithImage(PinDTO pinDTO, PinType type, MultipartFile image);
    PinDTO updatePin(PinDTO pinDTO);
    void deletePin(Long id);
    PinDTO promotePin(Long id);
    PinDTO featurePin(Long id);
    PinDTO addTagToPin(Long pinId, Long tagId);
    PinDTO removeTagFromPin(Long pinId, Long tagId);
}