package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "lesson_github")

public class LessonGithub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Readme") 
    @Lob
    @Column(name = "Description", columnDefinition="LONGTEXT")
    public String readme;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "github_checks_id")
    @JsonProperty("GitHubChecks") 
    public GithubChecks githubChecks;

    @OneToOne(mappedBy = "lessonGithub")
    private Lesson lesson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public GithubChecks getGithubChecks() {
        return githubChecks;
    }

    public void setGithubChecks(GithubChecks githubChecks) {
        this.githubChecks = githubChecks;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}