package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CLICommandData{
    @JsonProperty("ContainsCompleteDir") 
    public boolean containsCompleteDir;
    @JsonProperty("Commands")
    @ElementCollection
    public List<Command> commands;
}