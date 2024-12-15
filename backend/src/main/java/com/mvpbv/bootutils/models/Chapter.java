package com.mvpbv.bootutils.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;


public class Chapter{
    @JsonProperty("UUID") 
    public String uUID;
    @JsonProperty("Slug") 
    public String slug;
    @JsonProperty("Title") 
    public String title;
    @JsonProperty("Description") 
    public String description;
    @JsonProperty("RequiredLessons") 
    public ArrayList<RequiredLesson> requiredLessons;
    @JsonProperty("OptionalLessons") 
    public ArrayList<OptionalLesson> optionalLessons;
    @JsonProperty("NumRequiredLessons") 
    public int numRequiredLessons;
    @JsonProperty("NumOptionalLessons") 
    public int numOptionalLessons;
    @JsonProperty("CourseUUID") 
    public String courseUUID;
}