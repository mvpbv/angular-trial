package com.mvpbv.bootutils.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class RequiredLesson{
    @JsonProperty("UUID") 
    public String uUID;
    @JsonProperty("Slug") 
    public String slug;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("CourseUUID") 
    public String courseUUID;
    @JsonProperty("CourseTitle") 
    public String courseTitle;
    @JsonProperty("CourseImageURL") 
    public String courseImageURL;
    @JsonProperty("CourseSlug") 
    public String courseSlug;
    @JsonProperty("ChapterUUID") 
    public String chapterUUID;
    @JsonProperty("ChapterTitle") 
    public String chapterTitle;
    @JsonProperty("ChapterSlug") 
    public String chapterSlug;
    @JsonProperty("IsFree") 
    public boolean isFree;
    @JsonProperty("LastMod") 
    public Date lastMod;
    @JsonProperty("CompletionType") 
    public String completionType;
    @JsonProperty("Title") 
    public String title;
}