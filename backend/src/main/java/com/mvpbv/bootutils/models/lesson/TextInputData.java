package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextInputData{
    @JsonProperty("ContainsAll") 
    public List<String> containsAll;
    @JsonProperty("ContainsNone") 
    public Object containsNone;
    @JsonProperty("MatchesOne") 
    public Object matchesOne;
}
