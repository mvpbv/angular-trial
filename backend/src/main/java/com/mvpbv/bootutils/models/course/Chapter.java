package com.mvpbv.bootutils.models.course;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
}