package com.mvpbv.bootutils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvpbv.bootutils.models.Root;
import com.mvpbv.bootutils.repositories.RootRepository;

@Service
public class SeedDb {
    
    private static final Logger logger = Logger.getLogger(SeedDb.class.getName());   
    private final RestTemplate restTemplate;
    public final String baseUrl = "https://api.boot.dev/v1/static/courses?";
    private  final ObjectMapper objectMapper;
    private final RootRepository rootRepository;

    public SeedDb(RootRepository rootRepository, 
                  RestTemplate restTemplate,
                  ObjectMapper objectMapper) {
        this.rootRepository = rootRepository;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;

    }

    public void seedCourses() {
        logger.info("Starting the seeding process...");

        JsonNode response = restTemplate.getForObject(getBaseUrl(), JsonNode.class);
        
        if (response == null) {
            logger.log(Level.WARNING, "Failed to fetch data from {0}", baseUrl);
            return;
        }
        try {
            Root[] roots = objectMapper.readValue(response.toString(), Root[].class);
            for (Root root : roots) {
                rootRepository.save(root);
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to parse response", e);
        }
                    
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public void testDatabaseConnection() {
        rootRepository.count();
    logger.log(Level.INFO, "Database connection successful");
}

}