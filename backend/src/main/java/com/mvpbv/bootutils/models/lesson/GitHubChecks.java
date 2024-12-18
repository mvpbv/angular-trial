package com.mvpbv.bootutils.models.lesson;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "github_checks")
public class GithubChecks{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ContainsCompleteDir") 
    public boolean containsCompleteDir;


    @JsonProperty("ShowcaseRepo") 
    public String showcaseRepo;

    @OneToOne(mappedBy = "githubChecks")
    private LessonGithub LessonGithub;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isContainsCompleteDir() {
        return containsCompleteDir;
    }

    public void setContainsCompleteDir(boolean containsCompleteDir) {
        this.containsCompleteDir = containsCompleteDir;
    }

    public String getShowcaseRepo() {
        return showcaseRepo;
    }

    public void setShowcaseRepo(String showcaseRepo) {
        this.showcaseRepo = showcaseRepo;
    }

    public LessonGithub getLessonGithub() {
        return LessonGithub;
    }

    public void setLessonGithub(LessonGithub lessonGithub) {
        this.LessonGithub = lessonGithub;
    }

}

