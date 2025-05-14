package com.pinboard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BoardDTO {
    
    private Long id;
    private String name;
    private String description;
    private String coverImageUrl;
    private boolean isPrivate;
    private Long userId;
    private List<Long> pinIds;
    private List<Long> collaboratorIds;
    private LocalDateTime createdAt;
}