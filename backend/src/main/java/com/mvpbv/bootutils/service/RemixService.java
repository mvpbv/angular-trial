package com.mvpbv.bootutils.service;

import com.mvpbv.bootutils.models.remix.RemixCourse;
import com.mvpbv.bootutils.models.remix.RemixLesson;
import com.mvpbv.bootutils.repositories.RemixCourseRepository;
import com.mvpbv.bootutils.repositories.RemixLessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Scanner;

@Service
public class RemixService {

  @Autowired
  private RemixCourseRepository remixCourseRepository;

  @Autowired
  private RemixLessonRepository remixLessonRepository;

  public List<RemixCourse> getCourses() {
    return remixCourseRepository.findAll();
  }
  public List<RemixLesson> getLessons() {
    return remixLessonRepository.findAll();
  }
}
