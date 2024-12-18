package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;


@Embeddable

public class ManualData{
    @JsonProperty("ContainsCompleteDir") 
    public boolean containsCompleteDir;

    public boolean isContainsCompleteDir() {
        return containsCompleteDir;
    }

    public void setContainsCompleteDir(boolean containsCompleteDir) {
        this.containsCompleteDir = containsCompleteDir;
    }
}