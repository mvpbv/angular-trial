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


@Entity
@Table(name = "lesson_code_sql")
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

    public String getProgLang() {
        return progLang;
    }

    public void setProgLang(String progLang) {
        this.progLang = progLang;
    }

    public List<StarterFile> getStarterFiles() {
        return starterFiles;
    }

    public void setStarterFiles(List<StarterFile> starterFiles) {
        this.starterFiles = starterFiles;
    }

    public List<SolutionFile> getSolutionFiles() {
        return solutionFiles;
    }

    public void setSolutionFiles(List<SolutionFile> solutionFiles) {
        this.solutionFiles = solutionFiles;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
