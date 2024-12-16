package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lesson_data_code_completion_sql")
@Getter @Setter @NoArgsConstructor
public class LessonDataCodeCompletionSQL{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Readme") 
    public String readme;

    @JsonProperty("ProgLang") 
    public String progLang;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonDataCodeCompletionSQL")
    @JsonProperty("StarterFiles") 
    public List<StarterFile> starterFiles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonDataCodeCompletionSQL")
    @JsonProperty("SolutionFiles") 
    public List<SolutionFile> solutionFiles;

    @OneToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
