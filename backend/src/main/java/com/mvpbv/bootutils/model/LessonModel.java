package com.mvpbv.bootutils.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class LessonModel{
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
    @JsonProperty("LessonDataCodeCompletion") 
    public Object lessonDataCodeCompletion;
    @JsonProperty("LessonDataCodeCompletionSQL") 
    public Object lessonDataCodeCompletionSQL;
    @JsonProperty("LessonDataMultipleChoice") 
    public Object lessonDataMultipleChoice;
    @JsonProperty("LessonDataHTTPTests") 
    public Object lessonDataHTTPTests;
    @JsonProperty("LessonDataGitHubChecks") 
    public Object lessonDataGitHubChecks;
    @JsonProperty("LessonDataManual") 
    public Object lessonDataManual;
    @JsonProperty("LessonDataCodeTests") 
    public CodeTestsModel lessonDataCodeTests;
    @JsonProperty("LessonDataTextInput") 
    public Object lessonDataTextInput;
    @JsonProperty("LessonDataCLICommand") 
    public Object lessonDataCLICommand;
}









 

