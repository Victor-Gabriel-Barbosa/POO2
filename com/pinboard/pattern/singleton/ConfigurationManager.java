package com.pinboard.pattern.singleton;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConfigurationManager {
    
    private static ConfigurationManager instance;
    private Map<String, Object> configuration;
    
    private ConfigurationManager() {
        configuration = new HashMap<>();
        loadDefaultConfiguration();
    }
    
    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
    
    public Object getConfigValue(String key) {
        return configuration.get(key);
    }
    
    public void setConfigValue(String key, Object value) {
        configuration.put(key, value);
    }
    
    private void loadDefaultConfiguration() {
        // Valores padrão
        configuration.put("maxUploadSizeMB", 10);
        configuration.put("featuredPinsLimit", 50);
        configuration.put("promotedPinsLimit", 20);
        configuration.put("popularPinsThreshold", 100);
        configuration.put("imageCacheTimeSeconds", 86400);
    }
}