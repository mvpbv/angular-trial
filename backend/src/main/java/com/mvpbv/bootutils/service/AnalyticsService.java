package com.mvpbv.bootutils.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mvpbv.bootutils.models.analytics.AnalyticsLesson;
import com.mvpbv.bootutils.models.analytics.AnalyticsStats;
import com.mvpbv.bootutils.models.analytics.LegacyHotSpot;
import com.mvpbv.bootutils.models.analytics.LessonType;
import com.mvpbv.bootutils.repositories.AnalyticsLessonRepository;


@Service
public class AnalyticsService {
    
    @Autowired
    private AnalyticsLessonRepository analyticsLessonRepository;
    private static final Logger logger = LoggerFactory.getLogger(AnalyticsService.class);

    public List<String> getCourseNames() {
        return analyticsLessonRepository.findCourseNames();
    }
    public List<String> getTrackNames() {
        return analyticsLessonRepository.findTrackNames();
    }
    public List<String> getLessonTypes() {
        return analyticsLessonRepository.findLessonTypes();
    }

    public List<AnalyticsLesson> getLessonDataBy(List<String> courseNames) {
        if (courseNames == null) {
            logger.info("No course names provided");
        }
        List<AnalyticsLesson> lessons = analyticsLessonRepository.findByCourseNames(courseNames);
        if (lessons.isEmpty()) {
            logger.error("No lessons found for course names: {0}", courseNames);
        }
        logger.info("Returning {0} lessons for course names: {1}", new Object[]{lessons.size(), courseNames});
        return lessons;
    }
    public List<AnalyticsLesson> getLessonsByCourse(String courseName) {
        if (courseName == null) {
            return analyticsLessonRepository.findAll();
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

    public List<LegacyHotSpot> findLegacyHotSpots(int window) {
        List<AnalyticsLesson> codingLessons = analyticsLessonRepository.findArticleLessons();
        codingLessons.sort(Comparator.comparing(AnalyticsLesson::getRadix));
        List<LegacyHotSpot> LegacyHotSpots = new ArrayList<>();
        for (int i = 0; i < codingLessons.size() - window; i++) {
            List<AnalyticsLesson> subList = codingLessons.subList(i, i + window);
            int sum = subList.stream().mapToInt(AnalyticsLesson::getDifficulty).sum();
            LegacyHotSpot LegacyHotSpot = new LegacyHotSpot(sum, subList.toArray(new AnalyticsLesson[window]));
            LegacyHotSpots.add(LegacyHotSpot);
        }
        LegacyHotSpots.sort(Comparator.comparing(LegacyHotSpot::getSum).reversed());
        return LegacyHotSpots;
    }

    public List<LegacyHotSpot> removeOverlaps(int window, List<LegacyHotSpot> LegacyHotSpots) {
        var noOverlaps = new HashSet<LegacyHotSpot>();
    
        for (int i = 0; i < LegacyHotSpots.size() - window; i++) {
            noOverlaps.add(LegacyHotSpots.subList(i, i + window).stream().max(Comparator.comparing(LegacyHotSpot::getSum)).get());

        }
        return new ArrayList<>(noOverlaps);
    }

    
    public Map<Integer, List<LegacyHotSpot>> findLegacyHotSpotsGrouped(int window) {
        return findLegacyHotSpots(window).stream()
            .collect(Collectors.groupingBy(LegacyHotSpot::getSum, () -> new TreeMap<>(Comparator.reverseOrder()), Collectors.toList()));
    }
    public Map<Integer, List<LegacyHotSpot>> findLegacyHotSpotsGroupedByCourse(int window) {
        return findLegacyHotSpots(window).stream()
            .collect(Collectors.groupingBy(LegacyHotSpot::getCourseIndex, Collectors.toList()));
    }


    public AnalyticsStats findLegacyHotSpotStats(int window) {
        List<AnalyticsLesson> codingLessons = analyticsLessonRepository.findArticleLessons();
        codingLessons.sort(Comparator.comparing(AnalyticsLesson::getRadix));
        List<Integer> LegacyHotSpotSums = new ArrayList<>();
        for (int i = 0; i < codingLessons.size() - window; i++) {
            List<AnalyticsLesson> subList = codingLessons.subList(i, i + window);
            int sum = subList.stream().mapToInt(AnalyticsLesson::getDifficulty).sum();
            LegacyHotSpotSums.add(sum);
        }
    
        double avg = LegacyHotSpotSums.stream().mapToDouble(i -> i).sum() / LegacyHotSpotSums.size();
        double variance = LegacyHotSpotSums.stream().mapToDouble(i -> Math.pow(i - avg, 2)).sum() / (LegacyHotSpotSums.size() - 1);
        double stdDev = Math.sqrt(variance);
        int size = LegacyHotSpotSums.size();
        double median;
        if (size % 2 == 1) {
            median = LegacyHotSpotSums.get(size / 2);
        } else {
            median = (LegacyHotSpotSums.get(size / 2 - 1) + LegacyHotSpotSums.get(size / 2)) / 2.0;
        }
        int max = LegacyHotSpotSums.stream().mapToInt(Integer::intValue).max().orElse(0);
        int min = LegacyHotSpotSums.stream().mapToInt(Integer::intValue).min().orElse(0);
        return new AnalyticsStats(avg, stdDev, variance, median, max, min);
    }

    public AnalyticsStats findPrimaryStats(int window) {
        List<AnalyticsLesson> codingLessons = analyticsLessonRepository.findPrimaryLessons();
        codingLessons.sort(Comparator.comparing(AnalyticsLesson::getRadix));
        List<Integer> LegacyHotSpotSums = new ArrayList<>();
        for (int i = 0; i < codingLessons.size() - window; i++) {
            List<AnalyticsLesson> subList = codingLessons.subList(i, i + window);
            int sum = subList.stream().mapToInt(AnalyticsLesson::getDifficulty).sum();
            LegacyHotSpotSums.add(sum);
        }
    
        double avg = LegacyHotSpotSums.stream().mapToDouble(i -> i).sum() / LegacyHotSpotSums.size();
        double variance = LegacyHotSpotSums.stream().mapToDouble(i -> Math.pow(i - avg, 2)).sum() / (LegacyHotSpotSums.size() - 1);
        double stdDev = Math.sqrt(variance);
        int size = LegacyHotSpotSums.size();
        double median;
        if (size % 2 == 1) {
            median = LegacyHotSpotSums.get(size / 2);
        } else {
            median = (LegacyHotSpotSums.get(size / 2 - 1) + LegacyHotSpotSums.get(size / 2)) / 2.0;
        }
        int max = LegacyHotSpotSums.stream().mapToInt(Integer::intValue).max().orElse(0);
        int min = LegacyHotSpotSums.stream().mapToInt(Integer::intValue).min().orElse(0);
        return new AnalyticsStats(avg, stdDev, variance, median, max, min);
    }
       

}
