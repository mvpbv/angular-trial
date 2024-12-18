package com.mvpbv.bootutils.models.course;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;



@Embeddable

public class Alternatives {

    @JsonProperty("Typescript")
    private String typescript;
    
    @JsonProperty("Go")
    private String go;
    
    @JsonProperty("JavaScript")
    private String javascript;

    public Alternatives() {
    }

    public void setTypeScript(String typescript) {
        this.typescript = typescript;
    }
    public void setGo(String go) {
        this.go = go;
    }
    public void setJavaScript(String javascript) {
        this.javascript = javascript;
    }
    public String getTypeScript() {
        return typescript;
    }
    public String getGo() {
        return go;
    }
    public String getJavaScript() {
        return javascript;
    }
    



    
}