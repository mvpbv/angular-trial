package com.mvpbv.bootutils.model;

import com.fasterxml.jackson.annotation.JsonProperty;
public class StarterModel {

    @JsonProperty("Name") 
    public String name;
    @JsonProperty("Content") 
    public String content;
    @JsonProperty("IsHidden") 
    public boolean isHidden;
    @JsonProperty("IsReadonly") 
    public boolean isReadonly;
}
