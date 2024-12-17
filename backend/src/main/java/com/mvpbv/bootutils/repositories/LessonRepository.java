package com.mvpbv.bootutils.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvpbv.bootutils.models.lesson.Lesson;


public interface LessonRepository extends JpaRepository<Lesson, Long> {

}