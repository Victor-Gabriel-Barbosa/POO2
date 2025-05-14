package com.pinboard.pattern.decorator;

import com.pinboard.model.Pin;

public abstract class PinDecorator extends Pin {
    
    protected Pin decoratedPin;
    
    public PinDecorator(Pin decoratedPin) {
        this.decoratedPin = decoratedPin;
    }
    
    @Override
    public Long getId() {
        return decoratedPin.getId();
    }
    
    @Override
    public String getTitle() {
        return decoratedPin.getTitle();
    }
    
    @Override
    public String getDescription() {
        return decoratedPin.getDescription();
    }
    
    @Override
    public String getImageUrl() {
        return decoratedPin.getImageUrl();
    }
}