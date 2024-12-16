package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test{
    @JsonProperty("StatusCode") 
    public int statusCode;
    @JsonProperty("BodyContains") 
    public String bodyContains;
    @JsonProperty("BodyContainsNone") 
    public Object bodyContainsNone;
    @JsonProperty("HeadersContain") 
    public Object headersContain;
    @JsonProperty("JSONValue") 
    public JSONValue jSONValue;
}