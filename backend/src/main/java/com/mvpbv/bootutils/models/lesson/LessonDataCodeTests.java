package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "starter_files")
@Getter @Setter @NoArgsConstructor
public class LessonDataCodeTests{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Readme") 
    public String readme;

    @JsonProperty("ProgLang") 
    public String progLang;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="lessonDataCodeTests")
    @JsonProperty("StarterFiles") 
    public List<StarterFile> starterFiles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy= "lessonDataCodeTests")
    @JsonProperty("SolutionFiles") 
    @ElementCollection
    public List<SolutionFile> solutionFiles;
}