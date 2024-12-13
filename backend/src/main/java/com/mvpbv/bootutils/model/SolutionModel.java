package com.mvpbv.bootutils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolutionModel {
    public class SolutionFile{
        @JsonProperty("Name") 
        public String name;
        @JsonProperty("Content") 
        public String content;
        @JsonProperty("IsHidden") 
        public boolean isHidden;
        @JsonProperty("IsReadonly") 
        public boolean isReadonly;
    } 
}
