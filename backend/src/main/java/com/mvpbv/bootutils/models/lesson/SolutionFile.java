package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
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