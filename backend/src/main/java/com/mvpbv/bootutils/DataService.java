package com.mvpbv.bootutils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class DataService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Lessons lessons;
    private static final Logger logger = Logger.getLogger(DataService.class.getName());
    
    @Autowired
    public DataService(RestTemplate restTemplate, Lessons lessons) {
        this.restTemplate = new RestTemplate();
        this.lessons = lessons;
    }
    public JsonNode fetchCourseData(String url) {
        logger.log(Level.INFO, "Making request to {0}", url);
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        if (response == null) {
            logger.log(Level.WARNING, "Failed to fetch data from {0}", url);
            return null;
        }
        logger.log(Level.INFO, "Response received successfully");
        int nodeCount = countNodes(response);
        logger.log(Level.INFO, "Node count: {0}", nodeCount);
        ObjectNode filteredResponse = objectMapper.createObjectNode();
        filteredResponse = filterCourseResponse(response, filteredResponse);
        var lessonList = new ArrayList<String>();

        for (JsonNode codingLesson : filteredResponse.get("CodingLessons")) {
            lessonList.add(codingLesson.get("UUID").asText());
        }
        System.out.println(lessonList.size() + " lessons found:");
        var lessonsNode = objectMapper.createArrayNode();

        for (String lesson : lessonList) {
            lessonsNode.add(lessons.fetchLessonData("https://api.boot.dev/v1/static/lessons/" + lesson));
        }
                
        try {
            File file = new File("c-response.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, filteredResponse);
            logger.log(Level.INFO, "Full JSON Tree written to response.json:");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to pretty print response", e);
        }
        
        return lessonsNode;
    }
    private ObjectNode filterCourseResponse(JsonNode response, ObjectNode filtered) {
        if (response.has("Chapters")) {
            ArrayNode chapters = (ArrayNode) response.get("Chapters");
            //filteredResponse.set("Chapters", chapters);
            ArrayNode requiredLessons = objectMapper.createArrayNode();
            ArrayNode optionalLessons = objectMapper.createArrayNode();
            for (JsonNode chapter : chapters) {
                if (chapter.has("RequiredLessons")) {
                   requiredLessons.addAll((ArrayNode) chapter.get("RequiredLessons"));
                }
                if (chapter.has("OptionalLessons")) {
                    optionalLessons.addAll((ArrayNode) chapter.get("OptionalLessons"));
                }
            }
            ArrayNode codingLessons = objectMapper.createArrayNode();
            for (JsonNode requiredLesson : requiredLessons) {
                if (requiredLesson.has("Type")) {
                    if (requiredLesson.get("Type").asText().equals("type_code")) {
                        codingLessons.add(requiredLesson);
                    }
                    if (requiredLesson.get("Type").asText().equals("type_code_tests")) {
                        codingLessons.add(requiredLesson);
                    }
                    if (requiredLesson.get("Type").asText().equals("type_code_sql")) {
                        codingLessons.add(requiredLesson);
                    }
                    if (requiredLesson.get("Type").asText().equals("type_http_tests")) {
                        codingLessons.add(requiredLesson);
                    }
                }
            }
            for (JsonNode optionalLesson : optionalLessons) {
                if (optionalLesson.has("Type")) {
                    if (optionalLesson.get("Type").asText().equals("type_code")) {
                        codingLessons.add(optionalLesson);
                    }
                    if (optionalLesson.get("Type").asText().equals("type_code_tests")) {
                        codingLessons.add(optionalLesson);
                    }
                    if (optionalLesson.get("Type").asText().equals("type_code_sql")) {
                        codingLessons.add(optionalLesson);
                    }
                    if (optionalLesson.get("Type").asText().equals("type_http_tests")) {
                        codingLessons.add(optionalLesson);
                    }
                }
            }
            for (JsonNode codingLesson : codingLessons) {
                removeField(codingLesson, "IsFree");
                removeField(codingLesson, "CourseImageURL");
                removeField(codingLesson, "Type");
                removeField(codingLesson, "ChapterTitle");
                removeField(codingLesson, "CourseTitle");
            }
            filtered.set("CodingLessons", codingLessons);
        }
        return filtered;
    }

    private void removeField(JsonNode node, String fieldName) {
        if (node.isObject()) {
            ((ObjectNode) node).remove(fieldName);
        } else if (node.isArray()) {
            for (JsonNode child : node) {
                removeField(child, fieldName);
            }
        }
    }

    private int countNodes(JsonNode node) {
        if (node.isObject() || node.isArray()) {
            int count = 1;
            for (JsonNode child : node) {
                count += countNodes(child);
            }
            return count;
        }
        return 0;
    }
}