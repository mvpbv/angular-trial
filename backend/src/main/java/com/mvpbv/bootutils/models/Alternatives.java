package com.mvpbv.bootutils.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Alternatives {

    @JsonProperty("Typescript")
    private String typescript;
    
    @JsonProperty("Go")
    private String go;
    
    @JsonProperty("JavaScript")
    private String javascript;

    
}