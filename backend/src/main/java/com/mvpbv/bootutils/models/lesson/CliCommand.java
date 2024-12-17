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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cli_command_data")
@Getter @Setter @NoArgsConstructor
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
}
