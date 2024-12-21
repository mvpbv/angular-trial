package com.mvpbv.bootutils.models.analytics;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class CodeChallenge {
    @JsonProperty("Title")
    private String title;
    @Id
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
    @JsonProperty("CourseIndex")
    private int courseIndex;
    @JsonProperty("CourseName")
    private String courseName;
    @JsonProperty("TrackIndex")
    private int trackIndex;
    @JsonProperty("TrackName")
    private String trackName;
    @JsonProperty("Difficulty")
    private int difficulty;
    @JsonProperty("Chron")
    private int chron;


    public CodeChallenge(AnalyticsLesson lesson, int index) {
        this.title = lesson.getTitle();
        this.uuid = lesson.getUuid();
        this.isChallenge = lesson.isChallenge();
        this.lessonIndex = lesson.getLessonIndex();
        this.chapterIndex = lesson.getChapterIndex();
        this.chapterName = lesson.getChapterName();
        this.courseName = lesson.getCourseName();
        this.courseIndex = reindex(lesson.getCourseIndex());
        this.trackIndex = lesson.getTrackIndex();
        this.trackName = lesson.getTrackName();
        this.difficulty = lesson.getDifficulty();
        this.chron = index;
    }
    private int reindex(int courseIndex) {
        return switch(courseIndex) {
            case 1 -> 1;
            case 5 -> 2;
            case 7 -> 3;
            case 9 -> 4;
            case 10 -> 5;
            case 12 -> 6;
            case 14 -> 7;
            case 15 -> 8;
            case 17 -> 9;
            case 27 -> 10;
            case 28 -> 11;
            case 29 -> 12;
            case 30 -> 13;
            default -> 69;
        };
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
    public String getTrackName() {
        return trackName;
    }
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
    public int getChron() {
        return chron;
    }
    public void setChron(int index) {
        this.chron = index;
    }


    public CodeChallenge() {    

    }
}