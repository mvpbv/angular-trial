package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lesson_data_github_checks")
@Getter @Setter @NoArgsConstructor
public class LessonDataGitHubChecks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Readme") 
    public String readme;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "github_checks_id")
    @JsonProperty("GitHubChecks") 
    public GitHubChecks gitHubChecks;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}