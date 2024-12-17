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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "solution_files")
@Getter @Setter @NoArgsConstructor
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



}