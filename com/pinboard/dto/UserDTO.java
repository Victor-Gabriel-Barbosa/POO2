package com.pinboard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDTO {
    
    private Long id;
    private String username;
    private String email;
    private String name;
    private String password; // Usado apenas para criação/atualização
    private String profileImageUrl;
    private String bio;
    private int followersCount;
    private int followingCount;
    private int pinsCount;
    private int boardsCount;
    private List<Long> followingIds;
    private List<Long> followerIds;
    private LocalDateTime createdAt;
}