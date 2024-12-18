package com.mvpbv.bootutils.models.lesson;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;


@Embeddable


public class Jobs{
    @JsonProperty("Tests") 
    public List<String> tests;
    public List<String> getTests() {
        return tests;
    }

    public void setTests(List<String> tests) {
        this.tests = tests;
    }
}
