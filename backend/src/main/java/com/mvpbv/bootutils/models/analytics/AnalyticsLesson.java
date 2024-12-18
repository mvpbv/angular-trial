package com.mvpbv.bootutils.models.analytics;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvpbv.bootutils.models.lesson.Lesson;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class AnalyticsLesson {

        

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Title")
    private String title;
    @JsonProperty("UUID")
    private String uuid;
    @JsonProperty("IsChallenge")
    private boolean isChallenge;
    @JsonProperty("LessonIndex")
    private int lessonIndex;
    @JsonProperty("ChapterIndex")
    private int chapterIndex;
    @JsonProperty("ChapterName")
    private String chapterName;
    @Enumerated(EnumType.STRING)
    @JsonProperty("LessonType")
    private LessonType lessonType;
    @JsonProperty("IsLocalMachine")
    private boolean islocalMachine;
    @JsonProperty("CourseIndex")
    private int courseIndex;
    @JsonProperty("CourseName")
    private String courseName;
    @JsonProperty("TrackIndex")
    private int trackIndex;
    @JsonProperty("Difficulty")
    private int difficulty;

    public AnalyticsLesson(Lesson lesson) {
        this.title = lesson.getTitle();
        this.uuid = lesson.getUuid();
        this.isChallenge = lesson.getCompletionType().contains("challenge");
        this.lessonIndex = parseIndex(lesson.getSlug());
        this.chapterIndex = parseIndex(lesson.getChapterSlug());
        this.chapterName = lesson.getChapterTitle();
        this.lessonType = parseType(lesson.getType());
        this.islocalMachine = parseType(lesson.getType()) == LessonType.cli_local || parseType(lesson.getType()) == LessonType.code_local;
        this.courseIndex = getCourseIndex(lesson.getCourseSlug());
        this.courseName = lesson.getCourseTitle();
        this.trackIndex = getTrackIndex(this.courseIndex);
        this.difficulty = lesson.getLessonDifficulty();
    }
    private int parseIndex(String index) {
        var temp = index.split("-")[0];
        return Integer.parseInt(temp);
    }
    private LessonType parseType(String type) {
        return switch(type) {
            case "type_cli_command" -> LessonType.cli_local;
            case "type_choice" -> LessonType.quiz_browser;
            case "type_code", "type_code_tests", "type_code_sql" -> LessonType.code_browser;
            case "type_http_tests", "type_manual", "type_github_checks" -> LessonType.code_local;
            default -> LessonType.unknown;
        };
    }
    private int getCourseIndex(String courseSlug) {
        return switch (courseSlug) {
            case "learn-code-python" -> 1;
            case "learn-shells-and-terminals" -> 2;
            case "learn-git" -> 3;
            case "build-bookbot-python" -> 4;
            case "learn-object-oriented-programming-python" -> 5;
            case "build-asteroids-python" -> 6;
            case "learn-functional-programming-python" -> 7;
            case "build-static-site-generator-python" -> 8;
            case "learn-algorithms-python" -> 9;
            case "learn-data-structures-python" -> 10;
            case "build-maze-solver-python" -> 11;
            case "learn-memory-management-c" -> 12;
            case "build-personal-project-1" -> 13;
            case "learn-golang" -> 14;
            case "learn-http-clients-golang" -> 15;
            case "build-pokedex-cli-golang" -> 16;
            case "learn-sql" -> 17;
            case "build-blog-aggregator-golang" -> 18;
            case "learn-http-servers-golang" -> 19;
            case "learn-docker" -> 20;
            case "learn-ci-cd-github-docker-golang" -> 21;
            case "build-capstone-project" -> 22;
            case "learn-job-search" -> 23;
            case "learn-git-2" -> 24;
            case "learn-kubernetes" -> 25;
            case "learn-pub-sub-rabbitmq" -> 26;
            case "learn-crytography" -> 27;
            case "learn-algorithms-2" -> 28;
            case "learn-javascript" -> 29;
            case "learn-http-clients-typescript" -> 30;
            case "build-pokedex-cli-typescript" -> 31;
            case "build-blog-aggregator-typescript" -> 32;
            case "learn-http-servers-typescript" -> 33;
            default -> 1000;
        };
    }
    private int getTrackIndex(int courseIndex) {
        if (courseIndex > 28) return 3;
        else if (courseIndex > 23) return 4;
        else if (courseIndex > 13) return 2;
        else return 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isChallenge() {
        return isChallenge;
    }

    public void setChallenge(boolean isChallenge) {
        this.isChallenge = isChallenge;
    }

    public int getLessonIndex() {
        return lessonIndex;
    }

    public void setLessonIndex(int lessonIndex) {
        this.lessonIndex = lessonIndex;
    }

    public int getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(int chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public boolean isIslocalMachine() {
        return islocalMachine;
    }

    public void setIslocalMachine(boolean islocalMachine) {
        this.islocalMachine = islocalMachine;
    }

    public int getCourseIndex() {
        return courseIndex;
    }

    public void setCourseIndex(int courseIndex) {
        this.courseIndex = courseIndex;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTrackIndex() {
        return trackIndex;
    }

    public void setTrackIndex(int trackIndex) {
        this.trackIndex = trackIndex;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public AnalyticsLesson() {    

    }
}
