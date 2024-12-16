package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;

@Embeddable
public class Question{
    @JsonProperty("Question") 
    public String question;
    @JsonProperty("Answers") 
    @ElementCollection
    public List<String> answers;
    @JsonProperty("Answer") 
    public String answer;
    @JsonProperty("ContainsCompleteDir") 
    public boolean containsCompleteDir;
}
