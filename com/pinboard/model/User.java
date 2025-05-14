package com.pinboard.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private String profileImageUrl;
    
    @Column(length = 500)
    private String bio;
    
    private String name;
    
    @ManyToMany
    @JoinTable(
        name = "user_followers",
        joinColumns = @JoinColumn(name = "following_id"),
        inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private Set<User> followers = new HashSet<>();
    
    @ManyToMany(mappedBy = "followers")
    private Set<User> following = new HashSet<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pin> createdPins = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(
        name = "user_saved_pins",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "pin_id")
    )
    private Set<Pin> savedPins = new HashSet<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    // Helper methods
    public void follow(User userToFollow) {
        if (!this.equals(userToFollow)) {
            userToFollow.getFollowers().add(this);
            this.getFollowing().add(userToFollow);
        }
    }
    
    public void unfollow(User userToUnfollow) {
        userToUnfollow.getFollowers().remove(this);
        this.getFollowing().remove(userToUnfollow);
    }
    
    public void savePin(Pin pin) {
        this.savedPins.add(pin);
        pin.getSavedByUsers().add(this);
    }
    
    public void unsavePin(Pin pin) {
        this.savedPins.remove(pin);
        pin.getSavedByUsers().remove(this);
    }
}