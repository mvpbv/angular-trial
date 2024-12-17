package com.mvpbv.bootutils.models.lesson;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "github_checks")
@Getter @Setter @NoArgsConstructor
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

}

