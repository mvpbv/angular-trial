package com.mvpbv.bootutils.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.mvpbv.bootutils.models.analytics.AnalyticsLesson;
import com.mvpbv.bootutils.models.analytics.AnalyticsStats;
import com.mvpbv.bootutils.models.analytics.HotSpot;
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
    @GetMapping("/getTrackNames")
    public List<String> getTrackNames() {
        return analyticsService.getTrackNames();        
    }
    @GetMapping("/getLessonTypes") 
    public List<String> getLessonTypes() {
        return analyticsService.getLessonTypes();        
    }
    @GetMapping("/getLessonsByCourse")
    public List<AnalyticsLesson> getLessonsByCourse(@RequestParam String courseName) {
        return analyticsService.getLessonsByCourse(courseName);        
    }
    @GetMapping("/getLessonsByTrack")
    public List<AnalyticsLesson> getLessonsByTrack(@RequestParam String trackName) {
        return analyticsService.getLessonsByTrack(trackName);        
    }
    @GetMapping("/getLessonsByType")
    public List<AnalyticsLesson> getLessonsByType(@RequestParam String lessonType) {
        return analyticsService.getLessonsByType(lessonType);        
    }
    @GetMapping("/getArticleLessons")
    public List<AnalyticsLesson> getArticleLessons() {
        return analyticsService.getArticleLessons();        
    }
    @GetMapping("/getArticleCodeLessonCount")
    public int getArticleCodeLessonCount(@RequestParam String courseName) {
        return analyticsService.countArticleCodeLessons(courseName);        
    }
    @GetMapping("/getArticleTotalLessonCount")
    public int getArticleTotalLessonCount(@RequestParam String courseName) {
        return analyticsService.countArticleTotalLessons(courseName);        
    }
    @GetMapping("getCodingCourses") 
    public List<String> getCodingCourses() {
        return analyticsService.findCodingCourses();
    }
    @GetMapping("/getHotSpots")
    public List<HotSpot> getHotSpots(@RequestParam int window) {
        return analyticsService.findHotSpots(window);
    }
    @GetMapping("/getHotSpotsAvg")
    public AnalyticsStats getHotSpotsStats(@RequestParam int window) {
        return analyticsService.findHotSpotStats(window);
    }
    @GetMapping("/getHotSpotsGrouped")
    public Map<Integer, List<HotSpot>> getHotSpotsGrouped(@RequestParam int window) {
        return analyticsService.findHotSpotsGrouped(window);
    }
    @GetMapping("/getHotSpotsCourse")
    public Map<Integer, List<HotSpot>> getHotSpotsCourse(@RequestParam int window) {
        return analyticsService.findHotSpotsGroupedByCourse(window);
    }
    






}