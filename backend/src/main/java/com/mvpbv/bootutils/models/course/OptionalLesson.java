package com.mvpbv.bootutils.models.course;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;




@Embeddable

public class OptionalLesson{


    @JsonProperty("UUID") 
    private String UUID;

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

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCourseUUID() {
        return courseUUID;
    }

    public void setCourseUUID(String courseUUID) {
        this.courseUUID = courseUUID;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseImageURL() {
        return courseImageURL;
    }

    public void setCourseImageURL(String courseImageURL) {
        this.courseImageURL = courseImageURL;
    }

    public String getCourseSlug() {
        return courseSlug;
    }

    public void setCourseSlug(String courseSlug) {
        this.courseSlug = courseSlug;
    }

    public String getChapterUUID() {
        return chapterUUID;
    }

    public void setChapterUUID(String chapterUUID) {
        this.chapterUUID = chapterUUID;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public String getChapterSlug() {
        return chapterSlug;
    }

    public void setChapterSlug(String chapterSlug) {
        this.chapterSlug = chapterSlug;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getCompletionType() {
        return completionType;
    }

    public void setCompletionType(String completionType) {
        this.completionType = completionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
