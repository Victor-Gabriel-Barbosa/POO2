package com.pinboard.pattern.factory;

import com.pinboard.model.Pin;
import org.springframework.stereotype.Component;

@Component
public class PinFactory {
    
    public Pin createPin(PinType type) {
        Pin pin = new Pin();
        
        switch (type) {
            case STANDARD:
                pin.setType(Pin.PinType.STANDARD);
                break;
            case IMAGE:
                pin.setType(Pin.PinType.IMAGE);
                break;
            case VIDEO:
                pin.setType(Pin.PinType.VIDEO);
                break;
            case ARTICLE:
                pin.setType(Pin.PinType.ARTICLE);
                break;
            default:
                pin.setType(Pin.PinType.STANDARD);
        }
        
        return pin;
    }
}