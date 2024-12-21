package com.mvpbv.bootutils.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.analytics.AnalyticsLesson;
import com.mvpbv.bootutils.models.analytics.LessonType;


@Repository
public interface AnalyticsLessonRepository extends JpaRepository<AnalyticsLesson, Long>{
    @Query("SELECT DISTINCT lessonType FROM AnalyticsLesson")
    List<String> findLessonTypes();
    @Query("SELECT DISTINCT courseName FROM AnalyticsLesson")       
    List<String> findCourseNames();
    @Query("SELECT DISTINCT trackName FROM AnalyticsLesson")
    List<String> findTrackNames();
    @Query("SELECT a FROM AnalyticsLesson a WHERE a.courseName = :courseName")
    List<AnalyticsLesson> findByCourseName(String courseName);
    @Query("SELECT a FROM AnalyticsLesson a WHERE a.trackName = :trackName")
    List<AnalyticsLesson> findByTrackName(String trackName);
    @Query("SELECT a FROM AnalyticsLesson a WHERE a.lessonType = :lessonType")
    List<AnalyticsLesson> findByLessonType(LessonType lessonType);
    @Query("SELECT a FROM AnalyticsLesson a WHERE a.lessonType = 'code_browser' AND a.trackName = 'CS Fundamentals'")
    List<AnalyticsLesson> findArticleLessons();
    @Query("SELECT a FROM AnalyticsLesson a WHERE a.lessonType = 'code_browser' AND a.trackName = 'CS Fundamentals' AND a.courseName IN ('Learn Python','Object Oriented Programming', 'Functional Programming')")
    List<AnalyticsLesson> findPrimaryLessons();
    @Query("SELECT COUNT(a) FROM AnalyticsLesson a WHERE a.lessonType = 'code_browser' AND a.trackName = 'CS Fundamentals' AND a.courseName = :courseName")
    int countArticleCodeLessons(String courseName);
    @Query("SELECT COUNT(a) FROM AnalyticsLesson a WHERE a.trackName = 'CS Fundamentals' AND a.courseName = :courseName")
    int countArticleTotalLessons(String courseName);
    @Query("SELECT DISTINCT courseName FROM AnalyticsLesson a WHERE a.lessonType = 'code_browser'")
    List<String> findCodingCourses();

}
