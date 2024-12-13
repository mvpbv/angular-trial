package com.mvpbv.bootutils.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RootModel {

        @JsonProperty("Lesson") 
        public LessonModel lesson;
        @JsonProperty("LessonDifficulty") 
        public int lessonDifficulty;
    
}
