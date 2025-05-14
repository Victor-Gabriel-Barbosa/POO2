package com.pinboard.pattern.observer;

import com.pinboard.model.Pin;
import com.pinboard.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserPinObserver implements Observer {
    
    private User user;
    
    public UserPinObserver(User user) {
        this.user = user;
    }
    
    public UserPinObserver() {
        // Construtor vazio necessário para o Spring
    }
    
    @Override
    public void update(String message, Object object) {
        if (object instanceof Pin) {
            Pin pin = (Pin) object;
            
            // Notificar o usuário sobre a atualização do pin
            System.out.println("Notificando usuário " + (user != null ? user.getUsername() : "desconhecido") + 
                              " sobre: " + message + " - Pin: " + pin.getTitle());
        }
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
}