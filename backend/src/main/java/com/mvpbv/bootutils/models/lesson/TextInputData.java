package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

public class TextInputData{
    @JsonProperty("ContainsAll")
    @Lob
    @Column(name = "ContainsAll", columnDefinition="LONGTEXT")
    public List<String> containsAll;

    @JsonProperty("ContainsNone") 
    @Lob
    @Column(name = "ContainsNone", columnDefinition="LONGTEXT")
    public List<String> containsNone;

    @JsonProperty("MatchesOne") 
    @Lob
    @Column(name = "MatchesOne", columnDefinition="LONGTEXT")
    public List<String> matchesOne;

    public List<String> getContainsAll() {
        return containsAll;
    }

    public void setContainsAll(List<String> containsAll) {
        this.containsAll = containsAll;
    }

    public List<String> getContainsNone() {
        return containsNone;
    }

    public void setContainsNone(List<String> containsNone) {
        this.containsNone = containsNone;
    }

    public List<String> getMatchesOne() {
        return matchesOne;
    }

    public void setMatchesOne(List<String> matchesOne) {
        this.matchesOne = matchesOne;
    }
}
