package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;


@Embeddable
public class TestCli {
   @JsonProperty("ExitCode") 
    public int exitCode;
    @JsonProperty("StdoutContainsAll") 
    public Object stdoutContainsAll;
    @JsonProperty("StdoutContainsNone") 
    public Object stdoutContainsNone;
    @JsonProperty("StdoutLinesGt") 
    public Object stdoutLinesGt;
} 

