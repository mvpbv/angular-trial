package com.mvpbv.bootutils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvpbv.bootutils.models.Root;

public class SeedDb {

    private static final RestTemplate restTemplate = new RestTemplate();    
    public static final String baseUrl = "https://api.boot.dev/v1/static/courses?";
    private static final ObjectMapper objectMapper = new ObjectMapper();    
    private static final Logger logger = Logger.getLogger(SeedDb.class.getName());
    
    public static void seedCourses() {
        JsonNode response = restTemplate.getForObject(getBaseUrl(), JsonNode.class);
        
        if (response == null) {
            logger.log(Level.WARNING, "Failed to fetch data from {0}", baseUrl);
            return;
        }
        try {
            Root[] root = objectMapper.readValue(response.toString(), Root[].class);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to parse response", e);
        }

            
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

}