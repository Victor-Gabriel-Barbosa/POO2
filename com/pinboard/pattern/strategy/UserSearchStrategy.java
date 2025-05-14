package com.pinboard.pattern.strategy;

import com.pinboard.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserSearchStrategy implements SearchStrategy<User> {
    
    @Override
    public List<User> search(List<User> items, String query) {
        String lowerCaseQuery = query.toLowerCase();
        
        return items.stream()
                .filter(user -> 
                    user.getUsername().toLowerCase().contains(lowerCaseQuery) ||
                    (user.getName() != null && user.getName().toLowerCase().contains(lowerCaseQuery)) ||
                    user.getEmail().toLowerCase().contains(lowerCaseQuery)
                )
                .collect(Collectors.toList());
    }
}