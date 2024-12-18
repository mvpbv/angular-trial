package com.mvpbv.bootutils.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mvpbv.bootutils.models.course.CourseRoot;
import com.mvpbv.bootutils.models.lesson.Lesson;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "root", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<CourseRoot> courseRoots;

    @OneToMany(mappedBy = "root", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Lesson> lessons;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CourseRoot> getCourseRoots() {
        return courseRoots;
    }

    public void setCourseRoots(List<CourseRoot> courseRoots) {
        this.courseRoots = courseRoots;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
