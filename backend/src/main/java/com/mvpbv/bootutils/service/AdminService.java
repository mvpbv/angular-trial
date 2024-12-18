package com.mvpbv.bootutils.service;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mvpbv.bootutils.models.analytics.AnalyticsLesson;
import com.mvpbv.bootutils.models.course.CourseRoot;
import com.mvpbv.bootutils.models.lesson.Lesson;
import com.mvpbv.bootutils.repositories.AnalyticsLessonRepository;
import com.mvpbv.bootutils.repositories.CourseRootRepository;
import com.mvpbv.bootutils.repositories.LessonRepository;
import com.mvpbv.bootutils.repositories.RootRepository;

@Service
public class AdminService {
    
    private static final Logger logger = Logger.getLogger(AdminService.class.getName());   
    private final RestTemplate restTemplate;
    public final String baseUrl = "https://api.boot.dev/v1/static/courses?";
    public final String lessonsUrlRoot = "https://api.boot.dev/v1/static/lessons/";
    private  final ObjectMapper objectMapper;
    private final RootRepository rootRepository;
    private final CourseRootRepository courseRootRepository;
    private final LessonRepository lessonRepository;
    private final AnalyticsLessonRepository analyticsLessonRepository;


        
public AdminService(RootRepository rootRepository, 
                    RestTemplate restTemplate,
                    ObjectMapper objectMapper,
                    CourseRootRepository courseRootRepository,
                    LessonRepository lessonRepository,
                    AnalyticsLessonRepository analyticsLessonRepository) {
        this.rootRepository = rootRepository;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.courseRootRepository = courseRootRepository;
        this.lessonRepository = lessonRepository;
        this.analyticsLessonRepository = analyticsLessonRepository;
}

    public void seedCourses() {
        logger.info("Starting the seeding process...");

        JsonNode response = restTemplate.getForObject(getBaseUrl(), JsonNode.class);
        
        if (response == null) {
            logger.log(Level.WARNING, "Failed to fetch data from {0}", baseUrl);
            return;
        }
        try {
            CourseRoot[] roots = objectMapper.readValue(response.toString(), CourseRoot[].class);
            for (CourseRoot root : roots) {
                courseRootRepository.save(root);
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to parse response", e);
            throw new RuntimeException("Failed to parse response", e);
        }
                    
    }

    public String getBaseUrl() {
        return baseUrl;
    }
    public void testDatabaseConnection() {
        rootRepository.count();
        logger.log(Level.INFO, "Database connection successful");
    }
    public void seedOptionalLessons() {
        logger.info("Starting the seeding process...");

        var optLessons = rootRepository.getOptUuids();
        
        for (var optLesson : optLessons ) {
            JsonNode response = restTemplate.getForObject(lessonsUrlRoot + optLesson, JsonNode.class);
            ObjectNode desiredResponse = objectMapper.createObjectNode();
            if (response == null) {
                logger.log(Level.WARNING, "Failed to fetch data from {0}", lessonsUrlRoot + optLesson);
                return;
            }
            if (response.has("Lesson")) {
                desiredResponse.set("Lesson", response.get("Lesson"));
                desiredResponse = (ObjectNode) desiredResponse.get("Lesson");
            if (response.has("LessonDifficulty")) {
                var difficulty = response.get("LessonDifficulty");
                desiredResponse.set("LessonDifficulty", difficulty);                  
            }
            response = desiredResponse;
            }
            try {
                //logger.log(Level.INFO, "Response JSON: {0}", response.toString());
                Lesson lesson = objectMapper.readValue(response.toString(), Lesson.class);
                //logger.log(Level.INFO, "Parsed Lesson:{0}", lesson);
                lessonRepository.save(lesson);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Failed to parse response", e);
                throw new RuntimeException("Failed to parse response", e);
            }
        }
    }
    public void seedRequiredLessons() {
        logger.info("Starting the seeding process...");

        var reqLessons = rootRepository.getReqUuids();
        
        for (var reqLesson : reqLessons ) {
            JsonNode response = restTemplate.getForObject(lessonsUrlRoot + reqLesson, JsonNode.class);
            ObjectNode desiredResponse = objectMapper.createObjectNode();
            if (response == null) {
                logger.log(Level.WARNING, "Failed to fetch data from {0}", lessonsUrlRoot + reqLesson);
                return;
            }
            if (response.has("Lesson")) {
                desiredResponse.set("Lesson", response.get("Lesson"));
                desiredResponse = (ObjectNode) desiredResponse.get("Lesson");
            if (response.has("LessonDifficulty")) {
                var difficulty = response.get("LessonDifficulty");
                desiredResponse.set("LessonDifficulty", difficulty);                  
            }
            response = desiredResponse;
            }
            try {
                //logger.log(Level.INFO, "Response JSON: {0}", response.toString());
                Lesson lesson = objectMapper.readValue(response.toString(), Lesson.class);
                //logger.log(Level.INFO, "Parsed Lesson:{0}", lesson);
                lessonRepository.save(lesson);
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Failed to parse response", e);
                throw new RuntimeException("Failed to parse response", e);
            }
        }
    }
    public void seedAnalyticsLessons() {
        lessonRepository.findAll().forEach(lesson -> {
            analyticsLessonRepository.save(new AnalyticsLesson(lesson));
        });

    }
}
