package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "cli_command_data")

public class CliCommand{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ContainsCompleteDir") 
    private boolean containsCompleteDir;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="cliCommand")
    @JsonProperty("Commands")
    private List<Command> commands;

    @OneToOne(mappedBy = "cliCommand")
    private LessonCli lessonCli;

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

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public LessonCli getLessonCli() {
        return lessonCli;
    }

    public void setLessonCli(LessonCli lessonCli) {
        this.lessonCli = lessonCli;
    }
}
