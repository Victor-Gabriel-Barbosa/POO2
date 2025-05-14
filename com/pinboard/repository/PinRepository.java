package com.pinboard.repository;

import com.pinboard.model.Pin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long> {
    
    List<Pin> findByUserId(Long userId);
    
    @Query("SELECT p FROM Pin p JOIN p.tags t WHERE t.name = :tagName")
    List<Pin> findByTagName(String tagName);
    
    List<Pin> findByTitleContainingOrDescriptionContaining(String title, String description);
    
    Page<Pin> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable pageable);
    
    List<Pin> findByFeaturedIsTrue();
    
    List<Pin> findByPromotedIsTrue();
    
    @Query("SELECT p FROM Pin p ORDER BY p.viewCount DESC")
    List<Pin> findPopularPins(Pageable pageable);
    
    @Query("SELECT p FROM Pin p JOIN p.savedByUsers u WHERE u.id = :userId")
    List<Pin> findPinsSavedByUser(Long userId);
}