package com.mvpbv.bootutils.service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mvpbv.bootutils.models.analytics.AnalyticsLesson;
import com.mvpbv.bootutils.models.analytics.AnalyticsStats;
import com.mvpbv.bootutils.models.analytics.HotSpot;
import com.mvpbv.bootutils.models.analytics.LessonType;
import com.mvpbv.bootutils.repositories.AnalyticsLessonRepository;


@Service
public class AnalyticsService {
    
    @Autowired
    private AnalyticsLessonRepository analyticsLessonRepository;
    private static final Logger logger = LoggerFactory.getLogger(AnalyticsService.class);

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
    public List<String> getTrackNames() {
        return analyticsLessonRepository.findTrackNames();
    }
    public List<String> getLessonTypes() {
        return analyticsLessonRepository.findLessonTypes();
    }
    public List<AnalyticsLesson> getLessonsByCourse(String courseName) {
        if (courseName == null) {
            logger.info("No course name provided");
        }
        List<AnalyticsLesson> lessons = analyticsLessonRepository.findByCourseName(courseName);
        if (lessons.isEmpty()) {
            logger.error("No lessons found for course name: {0}", courseName);
        }
        logger.info("Returning {0} lessons for course name: {1}", new Object[]{lessons.size(), courseName});
        return lessons;
    }
    public List<AnalyticsLesson> getLessonsByTrack(String trackName) {
        if (trackName == null) {
            logger.info("No track index provided");
        }
        List<AnalyticsLesson> lessons = analyticsLessonRepository.findByTrackName(trackName);
        if (lessons.isEmpty()) {
            logger.error("No lessons found for track index: {0}", trackName);
        }
        logger.info("Returning {0} lessons for track index: {1}", new Object[]{lessons.size(), trackName});
        return lessons;
    }
    public List<AnalyticsLesson> getLessonsByType(String typeName) {
        if (typeName == null) {
            logger.info("No lesson type provided");
            return null;
        }
        LessonType lessonType;
        try {
            lessonType = LessonType.valueOf(typeName);

        } catch (Exception e) {
            logger.error("Error converting lesson type to uppercase: {0}", e.getMessage());
            return null;
        }
        List<AnalyticsLesson> lessons = analyticsLessonRepository.findByLessonType(lessonType);
        if (lessons.isEmpty()) {
            logger.error("No lessons found for lesson type: {0}", typeName);
        }
        logger.info("Returning {0} lessons for lesson type: {1}", new Object[]{lessons.size(), typeName});
        return lessons;
    }
    public List<AnalyticsLesson> getArticleLessons() {
        List<AnalyticsLesson> lessons = analyticsLessonRepository.findArticleLessons();
        if (lessons.isEmpty()) {
            logger.error("No lessons found for desired articles");
        }
        logger.info("Returning {0} lessons for desired articles", lessons.size());
        return lessons;
    }
    public int countArticleCodeLessons(String courseName) {
        int count = analyticsLessonRepository.countArticleCodeLessons(courseName);
        logger.info("Returning {0} article code lessons for course name: {1}", new Object[]{count, courseName});
        return count;
    }
    public int countArticleTotalLessons(String courseName) {
        int count = analyticsLessonRepository.countArticleTotalLessons(courseName);
        logger.info("Returning {0} total article lessons for course name: {1}", new Object[]{count, courseName});
        return count;
    }
    public List<String> findCodingCourses() {
        List<String> courses = analyticsLessonRepository.findCodingCourses();
        logger.info("Returning {0} coding courses", courses.size());
        return courses;
    }

    public List<HotSpot> findHotSpots( int window) {
        List<AnalyticsLesson> codingLessons = analyticsLessonRepository.findArticleLessons();
        codingLessons.sort(Comparator.comparing(AnalyticsLesson::getRadix));
        List<HotSpot> hotSpots = new ArrayList<>();
        for (int i = 0; i < codingLessons.size() - window; i++) {
            List<AnalyticsLesson> subList = codingLessons.subList(i, i + window);
            int sum = subList.stream().mapToInt(AnalyticsLesson::getDifficulty).sum();
            HotSpot hotSpot = new HotSpot(sum, subList.toArray(new AnalyticsLesson[window]));
            hotSpots.add(hotSpot);
        }
        hotSpots.sort(Comparator.comparing(HotSpot::getSum).reversed());
        return hotSpots;
    }
    

    public Map<Integer, List<HotSpot>> findHotSpotsGrouped(int window) {
        return findHotSpots(window).stream()
            .collect(Collectors.groupingBy(HotSpot::getSum, () -> new TreeMap<>(Comparator.reverseOrder()), Collectors.toList()));
    }
    public Map<Integer, List<HotSpot>> findHotSpotsGroupedByCourse(int window) {
        return findHotSpots(window).stream()
            .collect(Collectors.groupingBy(HotSpot::getCourseIndex, Collectors.toList()));

        
    }
    public AnalyticsStats findHotSpotStats(int window) {

        List<AnalyticsLesson> codingLessons = analyticsLessonRepository.findArticleLessons();
        codingLessons.sort(Comparator.comparing(AnalyticsLesson::getRadix));
        List<Integer> hotSpotSums = new ArrayList<>();
        for (int i = 0; i < codingLessons.size() - window; i++) {
            List<AnalyticsLesson> subList = codingLessons.subList(i, i + window);
            int sum = subList.stream().mapToInt(AnalyticsLesson::getDifficulty).sum();
            hotSpotSums.add(sum);
        }
        double avg = hotSpotSums.stream().mapToDouble(i -> i).sum() / hotSpotSums.size();
        double variance = hotSpotSums.stream().mapToDouble(i -> Math.pow(i - avg, 2)).sum() / (hotSpotSums.size() - 1);
        double stdDev = Math.sqrt(variance);
        double median = hotSpotSums.size() % 2 == 1 ? hotSpotSums.get(hotSpotSums.size() / 2) : hotSpotSums.get(hotSpotSums.size() / 2 - 1) + hotSpotSums.get(hotSpotSums.size() / 2) / 2;
        int max = hotSpotSums.stream().mapToInt(Integer::intValue).max().getAsInt();
        int min = hotSpotSums.stream().mapToInt(Integer::intValue).min().getAsInt();
        return new AnalyticsStats(avg, stdDev, variance, median, max, min);
    }

   

}
