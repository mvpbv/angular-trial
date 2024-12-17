package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "commands")
@Getter @Setter @NoArgsConstructor
public class Command{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Command") 
    private String command;
    /*
    @ElementCollection
    @CollectionTable(name = "command_tests",
    joinColumns = @JoinColumn(name = "command_id")
    )
    @JsonProperty("Tests") 
    private List<TestCli> tests;
    */
    @ManyToOne
    @JoinColumn(name = "cli_command_id")
    private CliCommand cliCommand;
}
