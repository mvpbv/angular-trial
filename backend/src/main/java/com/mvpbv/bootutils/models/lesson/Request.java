package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Request{
    @JsonProperty("Request") 
    public Request2 request2;
    @JsonProperty("Tests") 
    public List<Test> tests;
    @JsonProperty("ResponseVariables") 
    public Object responseVariables;
}
