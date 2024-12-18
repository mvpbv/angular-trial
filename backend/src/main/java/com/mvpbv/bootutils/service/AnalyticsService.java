package com.mvpbv.bootutils.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mvpbv.bootutils.models.analytics.AnalyticsLesson;
import com.mvpbv.bootutils.repositories.AnalyticsLessonRepository;

@Service
public class AnalyticsService {
    
    @Autowired
    private AnalyticsLessonRepository analyticsLessonRepository;

    public JsonNode getLessonData() {

        var analyticsLessons = analyticsLessonRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode lessonData = objectMapper.createArrayNode();
        for (var analyticsLesson : analyticsLessons) {
            JsonNode lessonNode = objectMapper.convertValue(analyticsLesson, JsonNode.class);
            lessonData.add(lessonNode);
        }
        return lessonData;
    }
    public List<String> getCourseNames() {
        return analyticsLessonRepository.findCourseNames();
    }
    public List<AnalyticsLesson> getLessonsByCourse(String courseName) {
        return analyticsLessonRepository.findByCourseName(courseName);
    }
}
