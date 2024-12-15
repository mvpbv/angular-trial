package com.mvpbv.bootutils.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class RequiredLesson{
    @JsonProperty("UUID") 
    private String uUID;

    @JsonProperty("Slug") 
    private String slug;

    @JsonProperty("Type") 
    private String type;

    @JsonProperty("CourseUUID") 
    private String courseUUID;

    @JsonProperty("CourseTitle") 
    private String courseTitle;

    @JsonProperty("CourseImageURL") 
    private String courseImageURL;

    @JsonProperty("CourseSlug") 
    private String courseSlug;

    @JsonProperty("ChapterUUID") 
    private String chapterUUID;

    @JsonProperty("ChapterTitle") 
    private String chapterTitle;

    @JsonProperty("ChapterSlug") 
    private String chapterSlug;

    @JsonProperty("IsFree") 
    private boolean isFree;

    @JsonProperty("LastMod") 
    private Date lastMod;

    @JsonProperty("CompletionType") 
    private String completionType;

    @JsonProperty("Title") 
    private String title;
}