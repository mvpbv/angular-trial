package com.mvpbv.bootutils.models.remix;

import jakarta.persistence.*;

@Entity
public class RemixLesson {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int remixLessonId;

  private String lessonTitle;

  @ManyToOne
  @JoinColumn(name = "remix_course_id", referencedColumnName = "remixCourseId")
  private RemixCourse remixCourse;

  private String lessonOverview;

  private String starterCode;



}
