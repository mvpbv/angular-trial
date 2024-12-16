package com.mvpbv.bootutils.models.lesson;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor

public class GitHubChecks{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ContainsCompleteDir") 
    public boolean containsCompleteDir;

    @JsonProperty("Steps") 
    @ElementCollection
    public List<Step> steps;

    @JsonProperty("ShowcaseRepo") 
    public Object showcaseRepo;

    @OneToOne(mappedBy = "gitHubChecks")
    private LessonDataGitHubChecks lessonDataGitHubChecks;

}

