package com.pinboard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TagDTO {
    
    private Long id;
    private String name;
    private int pinsCount;
    
    public TagDTO(Long id, String name, int pinsCount) {
        this.id = id;
        this.name = name;
        this.pinsCount = pinsCount;
    }
}