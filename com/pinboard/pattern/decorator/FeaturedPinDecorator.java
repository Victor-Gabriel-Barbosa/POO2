package com.pinboard.pattern.decorator;

import com.pinboard.model.Pin;

public class FeaturedPinDecorator extends PinDecorator {
    
    public FeaturedPinDecorator(Pin decoratedPin) {
        super(decoratedPin);
        decoratedPin.setFeatured(true);
    }
    
    @Override
    public String getTitle() {
        return "⭐ " + super.getTitle();
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + "\n\nThis is a featured pin selected by our editors!";
    }
}
