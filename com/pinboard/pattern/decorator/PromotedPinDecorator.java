package com.pinboard.pattern.decorator;

import com.pinboard.model.Pin;

public class PromotedPinDecorator extends PinDecorator {
    
    public PromotedPinDecorator(Pin decoratedPin) {
        super(decoratedPin);
        decoratedPin.setPromoted(true);
    }
    
    @Override
    public String getTitle() {
        return "📢 " + super.getTitle();
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + "\n\nThis is a promoted pin.";
    }
}