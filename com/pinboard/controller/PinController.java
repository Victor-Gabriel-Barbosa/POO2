// PinController.java
package com.pinboard.controller;

import com.pinboard.dto.PinDTO;
import com.pinboard.pattern.factory.PinType;
import com.pinboard.service.pin.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/pins")
public class PinController {

    private final PinService pinService;

    @Autowired
    public PinController(PinService pinService) {
        this.pinService = pinService;
    }

    @GetMapping
    public ResponseEntity<List<PinDTO>> getAllPins() {
        return ResponseEntity.ok(pinService.getAllPins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PinDTO> getPinById(@PathVariable Long id) {
        return ResponseEntity.ok(pinService.getPinById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<PinDTO>> searchPins(@RequestParam String query) {
        return ResponseEntity.ok(pinService.searchPins(query));
    }

    @PostMapping
    public ResponseEntity<PinDTO> createPin(@RequestBody PinDTO pinDTO, @RequestParam PinType type) {
        return new ResponseEntity<>(pinService.createPin(pinDTO, type), HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public ResponseEntity<PinDTO> createPinWithImage(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("userId") Long userId,
            @RequestParam("type") PinType type,
            @RequestParam("image") MultipartFile image) {
        
        PinDTO pinDTO = new PinDTO();
        pinDTO.setTitle(title);
        pinDTO.setDescription(description);
        pinDTO.setUserId(userId);
        
        return new ResponseEntity<>(pinService.createPinWithImage(pinDTO, type, image), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PinDTO> updatePin(@PathVariable Long id, @RequestBody PinDTO pinDTO) {
        pinDTO.setId(id);
        return ResponseEntity.ok(pinService.updatePin(pinDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePin(@PathVariable Long id) {
        pinService.deletePin(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/promote")
    public ResponseEntity<PinDTO> promotePin(@PathVariable Long id) {
        return ResponseEntity.ok(pinService.promotePin(id));
    }

    @PostMapping("/{id}/feature")
    public ResponseEntity<PinDTO> featurePin(@PathVariable Long id) {
        return ResponseEntity.ok(pinService.featurePin(id));
    }

    @PostMapping("/{pinId}/tags/{tagId}")
    public ResponseEntity<PinDTO> addTagToPin(@PathVariable Long pinId, @PathVariable Long tagId) {
        return ResponseEntity.ok(pinService.addTagToPin(pinId, tagId));
    }

    @DeleteMapping("/{pinId}/tags/{tagId}")
    public ResponseEntity<PinDTO> removeTagFromPin(@PathVariable Long pinId, @PathVariable Long tagId) {
        return ResponseEntity.ok(pinService.removeTagFromPin(pinId, tagId));
    }
}