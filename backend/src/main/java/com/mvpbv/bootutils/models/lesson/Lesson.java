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



@Entity

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



    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getCompletionType() {
        return completionType;
    }

    public String getSlug() {
        return slug;
    }

    public String getChapterSlug() {
        return chapterSlug;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public String getType() {
        return type;
    }

    public String getCourseSlug() {
        return courseSlug;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getLessonDifficulty() {
        return lessonDifficulty;
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setLessonDifficulty(int lessonDifficulty) {
        this.lessonDifficulty = lessonDifficulty;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCourseUUID(String courseUUID) {
        this.courseUUID = courseUUID;
    }

    public String getCourseUUID() {
        return courseUUID;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCourseImageURL(String courseImageURL) {
        this.courseImageURL = courseImageURL;
    }

    public String getCourseImageURL() {
        return courseImageURL;
    }

    public void setCourseSlug(String courseSlug) {
        this.courseSlug = courseSlug;
    }

    public void setChapterUUID(String chapterUUID) {
        this.chapterUUID = chapterUUID;
    }

    public String getChapterUUID() {
        return chapterUUID;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public void setChapterSlug(String chapterSlug) {
        this.chapterSlug = chapterSlug;
    }

    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public Date getLastMod() {
        return lastMod;
    }

    public void setCompletionType(String completionType) {
        this.completionType = completionType;
    }
    public LessonCodeOutput getLessonCodeOutput() {
        return lessonCodeOutput;
    }

    public void setLessonCodeOutput(LessonCodeOutput lessonCodeOutput) {
        this.lessonCodeOutput = lessonCodeOutput;
    }

    public LessonCodeSQL getLessonCodeSQL() {
        return lessonCodeSQL;
    }

    public void setLessonCodeSQL(LessonCodeSQL lessonCodeSQL) {
        this.lessonCodeSQL = lessonCodeSQL;
    }

    public LessonMultipleChoice getLessonMultipleChoice() {
        return lessonMultipleChoice;
    }

    public void setLessonMultipleChoice(LessonMultipleChoice lessonMultipleChoice) {
        this.lessonMultipleChoice = lessonMultipleChoice;
    }

    public LessonHttpTests getLessonHttpTests() {
        return lessonHttpTests;
    }

    public void setLessonHttpTests(LessonHttpTests lessonHttpTests) {
        this.lessonHttpTests = lessonHttpTests;
    }

    public LessonGithub getLessonGithub() {
        return lessonGithub;
    }

    public void setLessonGithub(LessonGithub lessonGithub) {
        this.lessonGithub = lessonGithub;
    }

    public LessonManual getLessonManual() {
        return lessonManual;
    }

    public void setLessonManual(LessonManual lessonManual) {
        this.lessonManual = lessonManual;
    }

    public LessonCodeTests getLessonCodeTests() {
        return lessonCodeTests;
    }

    public void setLessonCodeTests(LessonCodeTests lessonCodeTests) {
        this.lessonCodeTests = lessonCodeTests;
    }

    public LessonTextInput getLessonTextInput() {
        return lessonTextInput;
    }

    public void setLessonTextInput(LessonTextInput lessonTextInput) {
        this.lessonTextInput = lessonTextInput;
    }

    public LessonCli getLessonCli() {
        return lessonCli;
    }

    public void setLessonCli(LessonCli lessonCli) {
        this.lessonCli = lessonCli;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }
}


