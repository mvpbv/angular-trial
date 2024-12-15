package com.mvpbv.bootutils.models;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Root{
    @JsonProperty("UUID") 
    public String uUID;
    @JsonProperty("Slug") 
    public String slug;
    @JsonProperty("Title") 
    public String title;
    @JsonProperty("GenericTitle") 
    public String genericTitle;
    @JsonProperty("ShortDescription") 
    public String shortDescription;
    @JsonProperty("Description") 
    public String description;
    @JsonProperty("ThumbnailURL") 
    public String thumbnailURL;
    @JsonProperty("Difficulty") 
    public int difficulty;
    @JsonProperty("PrerequisiteCourseUUIDS") 
    public ArrayList<String> prerequisiteCourseUUIDS;
    @JsonProperty("EstimatedCompletionTimeHours") 
    public int estimatedCompletionTimeHours;
    @JsonProperty("TypeDescription") 
    public String typeDescription;
    @JsonProperty("LastUpdated") 
    public Date lastUpdated;
    @JsonProperty("SlugAliases") 
    public ArrayList<String> slugAliases;
    @JsonProperty("AuthorUUIDs") 
    public ArrayList<String> authorUUIDs;
    @JsonProperty("MaintainerUUIDs") 
    public ArrayList<String> maintainerUUIDs;
    @JsonProperty("Alternatives") 
    public Alternatives alternatives;
    @JsonProperty("Status") 
    public String status;
    @JsonProperty("NumRequiredLessons") 
    public int numRequiredLessons;
    @JsonProperty("NumOptionalLessons") 
    public int numOptionalLessons;
    @JsonProperty("Chapters") 
    public ArrayList<Chapter> chapters;
    @JsonProperty("Language") 
    public String language;
    @JsonProperty("CompletionXp") 
    public int completionXp;
    @JsonProperty("NumEnrolled") 
    public int numEnrolled;
}