package com.mvpbv.bootutils;

import java.io.File;
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

    private static final Logger logger = Logger.getLogger(DataService.class.getName());
    
    @Autowired
    public DataService(RestTemplate restTemplate) {
        this.restTemplate = new RestTemplate();
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
            lessonsNode.add(fetchLessonData("https://api.boot.dev/v1/static/lessons/" + lesson));
        }
                
        try {
            File file = new File("c-response.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, filteredResponse);
            logger.log(Level.INFO, "Full JSON Tree written to response.json:");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to pretty print response", e);
        }
        
        return lessonsNode;
    }
    public JsonNode fetchLessonData(String url) {
        logger.log(Level.INFO, "Making request to {0}", url);
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        if (response == null) {
            logger.log(Level.WARNING, "Failed to fetch data from {0}", url);
            return null;
        }
        logger.log(Level.INFO, "Response received successfully");
        int nodeCount = countNodes(response);
        logger.log(Level.INFO, "Node count: {0}", nodeCount);
        var filteredResponse = new ObjectMapper().createObjectNode();
        filteredResponse = filterLessonResponse(response, filteredResponse);
        var processedResponse = processLesson(filteredResponse);
        try {
            File file = new File("l-response.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, response);
            logger.log(Level.INFO, "Full JSON Tree written to response.json:");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Failed to pretty print response", e);
        }
        
        return processedResponse;
    }
    private ObjectNode processLesson(JsonNode lesson) {
        ObjectNode newNode = objectMapper.createObjectNode();
        if (lesson.has("CompletionType")) {
            var challenge = lesson.get("CompletionType").asText().equals("completion_type_challenge");
            newNode.put("Challenge", challenge);
        }
        if (lesson.has("Slug")) {
            String slug = lesson.get("Slug").asText();
            int leastPriority = Integer.parseInt(slug.split("-")[0]);
            newNode.put("leastPriority", leastPriority);
        }
        if (lesson.has("ChapterSlug")) {
            String chapterSlug = lesson.get("ChapterSlug").asText();
            int middlePriority = Integer.parseInt(chapterSlug.split("-")[0]);
            newNode.put("middlePriority", middlePriority);
        }
        if (lesson.has("CourseSlug")) {
            switch (lesson.get("CourseSlug").asText()) {
                case "learn-code-python" -> newNode.put("highPriority", 1);
                case "learn-object-oriented-programming-python" -> newNode.put("highPriority", 2);
                case "learn-functional-programming-python" -> newNode.put("highPriority", 3);
                case "learn-algorithms-python" -> newNode.put("highPriority", 4);
                case "learn-data-structures-python" -> newNode.put("highPriority", 5);
                case "learn-memory-management-python" -> newNode.put("highPriority", 6);
                case "learn-golang" -> newNode.put("highPriority", 7);
                case "learn-http-clients-golang" -> newNode.put("highPriority", 8);
                case "learn-javascript" -> newNode.put("highPriority", 9);
                case "learn-http-clients-javascript" -> newNode.put("highPriority", 10);

                default -> newNode.put("highPriority", 1000);
            }
        }
        if (lesson.has("Difficulty")) {
            newNode.set("Diff", lesson.get("Difficulty"));
        }
        if (lesson.has("Title")) {
            newNode.set("Title", lesson.get("Title"));
        }
        return newNode;
    }

    private ObjectNode filterLessonResponse(JsonNode response, ObjectNode filtered) {
        if (response.has("LessonDifficulty")) {
            filtered.set("Difficulty", response.get("LessonDifficulty"));
        }
        if (response.has("Lesson")) {
            JsonNode lesson = response.get("Lesson");
            filtered.set("Slug", lesson.get("Slug"));
            filtered.set("ChapterSlug", lesson.get("ChapterSlug"));
            filtered.set("Title", lesson.get("Title"));
            filtered.set("CourseSlug", lesson.get("CourseSlug"));
            filtered.set("CompletionType", lesson.get("CompletionType"));
        }

        return filtered;
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