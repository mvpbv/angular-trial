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
public class Request2{
    @JsonProperty("Method") 
    public String method;
    @JsonProperty("Path") 
    public String path;
    @JsonProperty("BasicAuth") 
    public Object basicAuth;
    @JsonProperty("BodyJSON") 
    public BodyJSON bodyJSON;
    @JsonProperty("Headers") 
    public Object headers;
    @JsonProperty("Actions") 
    public Actions actions;
}