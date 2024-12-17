package com.mvpbv.bootutils.models.lesson;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvpbv.bootutils.models.Root;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Long id;

    @JsonProperty("UUID")
    private String uuid;

    @JsonProperty("LessonDifficulty")
    private int lessonDifficulty;

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

    @JsonProperty("LessonDataCodeCompletion") 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "lesson_code_output_id")
    private LessonCodeOutput lessonCodeOutput;

    @JsonProperty("LessonDataCodeCompletionSQL") 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "lesson_code_completion_sql_id")
    private LessonCodeSQL lessonCodeSQL;

    @JsonProperty("LessonDataMultipleChoice") 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "lesson_multiple_choice_id")
    private LessonMultipleChoice lessonMultipleChoice;

    @JsonProperty("LessonDataHTTPTests") 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "lesson_http_tests_id")
    private LessonHttpTests lessonHttpTests;

    @JsonProperty("LessonDataGitHubChecks") 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "lesson_github_id")
    private LessonGithub lessonGithub;

    @JsonProperty("LessonDataManual") 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "lesson_manual_id")
    private LessonManual lessonManual;

    @JsonProperty("LessonDataCodeTests") 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "lesson_code_tests_id")
    private LessonCodeTests lessonCodeTests;

    @JsonProperty("LessonDataTextInput") 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "text_input_id")
    private LessonTextInput lessonTextInput;

    @JsonProperty("LessonDataCLICommand") 
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "cli_command_id")
    private LessonCli lessonCli;

    @ManyToOne
    @JoinColumn(name = "root_id")
    @JsonBackReference
    private Root root;
}


