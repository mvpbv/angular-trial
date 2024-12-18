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
@Table(name ="lesson_cli")

public class LessonCli{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("Readme") 
    @Lob
    @Column(name = "Description", columnDefinition="LONGTEXT")
    public String readme;

    @JsonProperty("CLICommandData") 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cli_command_id")
    public CliCommand cliCommand;

    @OneToOne(mappedBy = "lessonCli")
    private Lesson lesson;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public CliCommand getCliCommand() {
        return cliCommand;
    }

    public void setCliCommand(CliCommand cliCommand) {
        this.cliCommand = cliCommand;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}

