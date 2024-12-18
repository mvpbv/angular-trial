package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "solution_files")

public class SolutionFile{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("Name") 
    public String name;

    @JsonProperty("Content")
    @Lob
    @Column(name = "Content", columnDefinition="LONGTEXT")
    public String content;

    @JsonProperty("IsHidden") 
    public boolean isHidden;

    @JsonProperty("IsReadonly") 
    public boolean isReadonly;

    @ManyToOne
    @JoinColumn(name = "lesson_code_output_id")
    private LessonCodeOutput lessonCodeOutput;

    @ManyToOne
    @JoinColumn(name = "lesson_code_sql_id")
    private LessonCodeSQL lessonCodeSQL;

    @ManyToOne
    @JoinColumn(name = "lesson_http_tests_id")
    private LessonHttpTests lessonHttpTests;

    @ManyToOne
    @JoinColumn(name = "lesson_cli_id")
    private LessonCli lessonCli;

    @ManyToOne
    @JoinColumn(name = "lesson_code_tests_id")
    private LessonCodeTests lessonCodeTests;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public boolean isReadonly() {
        return isReadonly;
    }

    public void setReadonly(boolean readonly) {
        isReadonly = readonly;
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

    public LessonHttpTests getLessonHttpTests() {
        return lessonHttpTests;
    }

    public void setLessonHttpTests(LessonHttpTests lessonHttpTests) {
        this.lessonHttpTests = lessonHttpTests;
    }

    public LessonCli getLessonCli() {
        return lessonCli;
    }

    public void setLessonCli(LessonCli lessonCli) {
        this.lessonCli = lessonCli;
    }

    public LessonCodeTests getLessonCodeTests() {
        return lessonCodeTests;
    }

    public void setLessonCodeTests(LessonCodeTests lessonCodeTests) {
        this.lessonCodeTests = lessonCodeTests;
    }


}