package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;



@Embeddable

public class Actions{
    @JsonProperty("DelayRequestByMs") 
    private int delayRequestByMs;

    public int getDelayRequestByMs() {
        return delayRequestByMs;
    }

    public void setDelayRequestByMs(int delayRequestByMs) {
        this.delayRequestByMs = delayRequestByMs;
    }

}







