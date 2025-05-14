package com.pinboard.dto;

import com.pinboard.model.Pin.PinType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class PinDTO {
    
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String externalLink;
    private PinType type;
    private boolean featured;
    private boolean promoted;
    private int viewCount;
    private int likesCount;
    private int savesCount;
    private Long userId;  // ID do usuário proprietário do pin
    private List<Long> tagIds;
    private LocalDateTime createdAt;
}