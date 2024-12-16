package com.mvpbv.bootutils.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mvpbv.bootutils.models.course.CourseRoot;
import com.mvpbv.bootutils.models.lesson.LessonRoot;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "root", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CourseRoot> courseRoots;

    @OneToMany(mappedBy = "root", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<LessonRoot> lessonRoots;
}
