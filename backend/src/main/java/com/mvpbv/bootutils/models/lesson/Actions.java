package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Embeddable
@Getter @Setter @NoArgsConstructor
public class Actions{
    @JsonProperty("DelayRequestByMs") 
    public int  delayRequestByMs;

}







