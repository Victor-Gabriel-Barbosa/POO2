package com.pinboard.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "boards")
@Data
@NoArgsConstructor
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    private String description;
    
    private String coverImageUrl;
    
    @Column(nullable = false)
    private boolean isPrivate = false;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "board_pins",
        joinColumns = @JoinColumn(name = "board_id"),
        inverseJoinColumns = @JoinColumn(name = "pin_id")
    )
    private Set<Pin> pins = new HashSet<>();
    
    @ManyToMany
    @JoinTable(
        name = "board_collaborators",
        joinColumns = @JoinColumn(name = "board_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> collaborators = new HashSet<>();
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    // Helper methods
    public void addPin(Pin pin) {
        pins.add(pin);
        pin.getBoards().add(this);
    }
    
    public void removePin(Pin pin) {
        pins.remove(pin);
        pin.getBoards().remove(this);
    }
    
    public void addCollaborator(User user) {
        collaborators.add(user);
    }
    
    public void removeCollaborator(User user) {
        collaborators.remove(user);
    }
}