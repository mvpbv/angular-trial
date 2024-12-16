package com.mvpbv.bootutils.models.lesson;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter

public class Jobs{
    @JsonProperty("Tests") 
    public List<String> tests;
}
