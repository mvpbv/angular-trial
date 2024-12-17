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
}
