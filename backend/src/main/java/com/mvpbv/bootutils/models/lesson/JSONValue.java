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
public class JSONValue{
    @JsonProperty("Path") 
    public String path;
    @JsonProperty("Operator") 
    public String operator;
    @JsonProperty("IntValue") 
    public Integer intValue;
    @JsonProperty("StringValue") 
    public String stringValue;
    @JsonProperty("BoolValue") 
    public Boolean boolValue;
}
