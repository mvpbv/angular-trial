package com.mvpbv.bootutils.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvpbv.bootutils.models.lesson.Lesson;


public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query(value = "SELECT * FROM lessons", nativeQuery = true)
   List<Lesson> getAllLessonDetails();
}