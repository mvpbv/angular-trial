package com.mvpbv.bootutils.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.mvpbv.bootutils.models.analytics.AnalyticsLesson;
import com.mvpbv.bootutils.service.AnalyticsService;


@RestController
@RequestMapping("/api/v1/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/getAllLessonData")
    public JsonNode getLessonData() {
        return analyticsService.getLessonData();        
    }
    @GetMapping("/getCourseNames")
    public List<String> getCourseNames() {
        return analyticsService.getCourseNames();        
    }
    @GetMapping("/getLessonsByCourse")
    public List<AnalyticsLesson> getLessonsByCourse(@RequestParam String courseName) {
        return analyticsService.getLessonsByCourse(courseName);        
    }
    






}