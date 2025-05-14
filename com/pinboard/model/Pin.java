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
@Table(name = "pins")
@Data
@NoArgsConstructor
public class Pin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(length = 1000)
    private String description;
    
    @Column(nullable = false)
    private String imageUrl;
    
    private String externalLink;
    
    @Enumerated(EnumType.STRING)
    private PinType type = PinType.STANDARD;
    
    private boolean featured = false;
    
    private boolean promoted = false;
    
    private int viewCount = 0;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "pin_tags",
        joinColumns = @JoinColumn(name = "pin_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();
    
    @ManyToMany(mappedBy = "savedPins")
    private Set<User> savedByUsers = new HashSet<>();
    
    @ManyToMany
    @JoinTable(
        name = "pin_likes",
        joinColumns = @JoinColumn(name = "pin_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> likedByUsers = new HashSet<>();
    
    @ManyToMany(mappedBy = "pins")
    private Set<Board> boards = new HashSet<>();
    
    @Transient
    private PinUpdateSubject subject = new PinUpdateSubject();
    
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    // Helper methods
    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getPins().add(this);
    }
    
    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getPins().remove(this);
    }
    
    public void like(User user) {
        likedByUsers.add(user);
    }
    
    public void unlike(User user) {
        likedByUsers.remove(user);
    }
    
    // Incrementar visualizações
    public void incrementViews() {
        this.viewCount++;
    }
    
    public enum PinType {
        STANDARD, IMAGE, VIDEO, ARTICLE
    }
    
    // Adicionando getter para subject
    public PinUpdateSubject getSubject() {
        return subject;
    }
}

class PinUpdateSubject {
    private Set<Observer> observers = new HashSet<>();
    
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    public Set<Observer> getObservers() {
        return observers;
    }
}

interface Observer {
    void update(Pin pin);
}