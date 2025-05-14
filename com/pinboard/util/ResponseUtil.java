// ResponseUtil.java
package com.pinboard.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseUtil {
    
    public <T> ResponseEntity<T> success(T data) {
        return ResponseEntity.ok(data);
    }
    
    public ResponseEntity<Map<String, String>> error(String message, HttpStatus status) {
        Map<String, String> error = new HashMap<>();
        error.put("error", message);
        return new ResponseEntity<>(error, status);
    }
    
    public ResponseEntity<Map<String, String>> created(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    public ResponseEntity<Void> noContent() {
        return ResponseEntity.noContent().build();
    }
}