package com.pinboard.pattern.observer;

import com.pinboard.model.Pin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PinUpdateSubject implements Subject {
    
    private List<Observer> observers = new ArrayList<>();
    
    @Override
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers(String message, Object object) {
        for (Observer observer : observers) {
            observer.update(message, object);
        }
    }
    
    public List<Observer> getObservers() {
        return observers;
    }
    
    public void notifyObservers(Pin pin) {
        notifyObservers("Pin updated", pin);
    }
    
    public void pinCreated(Pin pin) {
        notifyObservers("Pin created", pin);
    }
    
    public void pinUpdated(Pin pin) {
        notifyObservers("Pin updated", pin);
    }
    
    public void pinDeleted(Pin pin) {
        notifyObservers("Pin deleted", pin);
    }
}