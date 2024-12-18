package com.mvpbv.bootutils.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvpbv.bootutils.models.analytics.AnalyticsLesson;

@Repository
public interface AnalyticsLessonRepository extends JpaRepository<AnalyticsLesson, Long>{
    @Query("SELECT DISTINCT courseName FROM AnalyticsLesson")       
    List<String> findCourseNames();
    @Query("SELECT a FROM AnalyticsLesson a WHERE a.courseName = :courseName")
    List<AnalyticsLesson> findByCourseName(String courseName);
}
