package com.mvpbv.bootutils.models.course;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Chapter{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("UUID") 
    private String uUID;

    @JsonProperty("Slug") 
    private String slug;

    @JsonProperty("Title") 
    private String title;

    @JsonProperty("Description") 
    private String description;

    @ManyToOne
    private CourseRoot root;

    @JsonProperty("RequiredLessons") 
    @ElementCollection
    private List<RequiredLesson> requiredLessons;

    @JsonProperty("OptionalLessons") 
    @ElementCollection
    private List<OptionalLesson> optionalLessons;

    @JsonProperty("NumRequiredLessons") 
    private int numRequiredLessons;

    @JsonProperty("NumOptionalLessons") 
    private int numOptionalLessons;

    @JsonProperty("CourseUUID") 
    private String courseUUID;


    public Chapter() {
    }

    public void setUUID(String uUID) {
        this.uUID = uUID;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setRoot(CourseRoot root) {
        this.root = root;
    }
    public void setRequiredLessons(List<RequiredLesson> requiredLessons) {
        this.requiredLessons = requiredLessons;
    }
    public void setOptionalLessons(List<OptionalLesson> optionalLessons) {
        this.optionalLessons = optionalLessons;
    }
    public void setNumRequiredLessons(int numRequiredLessons) {
        this.numRequiredLessons = numRequiredLessons;
    }
    public void setNumOptionalLessons(int numOptionalLessons) {
        this.numOptionalLessons = numOptionalLessons;
    }
    public void setCourseUUID(String courseUUID) {
        this.courseUUID = courseUUID;
    }
    public String getUUID() {
        return uUID;
    }
    public String getSlug() {
        return slug;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public CourseRoot getRoot() {
        return root;
    }
    public List<RequiredLesson> getRequiredLessons() {
        return requiredLessons;
    }
    public List<OptionalLesson> getOptionalLessons() {
        return optionalLessons;
    }
    public int getNumRequiredLessons() {
        return numRequiredLessons;
    }
    public int getNumOptionalLessons() {
        return numOptionalLessons;
    }
    public String getCourseUUID() {
        return courseUUID;
    }
    public Long getId() {
        return id;
    }
}