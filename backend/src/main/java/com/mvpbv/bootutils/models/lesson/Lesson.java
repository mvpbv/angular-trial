package com.mvpbv.bootutils.models.lesson;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @JsonProperty("UUID") 
    public String uuid;

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
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "codeCompletionData")
    public LessonDataCodeCompletion lessonDataCodeCompletion;

    @JsonProperty("LessonDataCodeCompletionSQL") 
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "codeCompletionSQLData")
    public LessonDataCodeCompletionSQL lessonDataCodeCompletionSQL;

    @JsonProperty("LessonDataMultipleChoice") 
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "multipleChoiceData")
    public LessonDataMultipleChoice lessonDataMultipleChoice;

    @JsonProperty("LessonDataHTTPTests") 
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "httpTestsData")
    public LessonDataHttpTests lessonDataHttpTests;

    @JsonProperty("LessonDataGitHubChecks") 
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "gitHubChecksData")
    public LessonDataGitHubChecks lessonDataGitHubChecks;

    @JsonProperty("LessonDataManual") 
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "manualData")
    public LessonDataManual lessonDataManual;

    @JsonProperty("LessonDataCodeTests") 
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "codeTestsData")
    public LessonDataCodeTests lessonDataCodeTests;

    @JsonProperty("LessonDataTextInput") 
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "textInputData")
    public LessonDataTextInput lessonDataTextInput;

    @JsonProperty("LessonDataCLICommand") 
    @OneToOne(cascade=CascadeType.ALL, mappedBy = "cliCommandData")
    public LessonDataCLICommand lessonDataCLICommand;
}


