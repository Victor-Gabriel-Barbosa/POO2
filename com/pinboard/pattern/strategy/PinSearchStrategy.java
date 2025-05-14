package com.pinboard.pattern.strategy;

import com.pinboard.model.Pin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PinSearchStrategy implements SearchStrategy<Pin> {
    
    @Override
    public List<Pin> search(List<Pin> items, String query) {
        String lowerCaseQuery = query.toLowerCase();
        
        return items.stream()
                .filter(pin -> 
                    pin.getTitle().toLowerCase().contains(lowerCaseQuery) ||
                    (pin.getDescription() != null && pin.getDescription().toLowerCase().contains(lowerCaseQuery))
                )
                .collect(Collectors.toList());
    }
}