package com.mvpbv.bootutils.models.remix;

import com.mvpbv.bootutils.models.links.CourseInfo;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class RemixCourse {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int remixCourseId;

  @OneToOne
  @JoinColumn(name = "course_index", referencedColumnName = "courseIndex")
  private CourseInfo courseInfo;

  @OneToMany
  @JoinColumn(name = "remix_course_id", referencedColumnName = "remixCourseId")
  private List<RemixLesson> remixLessons;

  private String courseTitle;


}
