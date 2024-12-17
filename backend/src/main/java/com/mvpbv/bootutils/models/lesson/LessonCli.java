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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name ="lesson_cli")
@Getter
@Setter
@NoArgsConstructor
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
}

