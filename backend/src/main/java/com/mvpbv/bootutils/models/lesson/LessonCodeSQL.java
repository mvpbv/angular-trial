package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lesson_code_sql")
@Getter @Setter @NoArgsConstructor
public class LessonCodeSQL{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Readme")
    @Lob
    @Column(name = "Description", columnDefinition="LONGTEXT")       
    public String readme;

    @JsonProperty("ProgLang") 
    public String progLang;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonCodeSQL")
    @JsonProperty("StarterFiles") 
    public List<StarterFile> starterFiles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonCodeSQL")
    @JsonProperty("SolutionFiles") 
    public List<SolutionFile> solutionFiles;

    @OneToOne(mappedBy = "lessonCodeSQL")   
    private Lesson lesson;
}
