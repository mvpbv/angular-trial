/*
package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "test")
@Getter @Setter @NoArgsConstructor
public class Test{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("StatusCode") 
    public int statusCode;

    @JsonProperty("BodyContains") 
    public String bodyContains;

    @JsonProperty("BodyContainsNone") 
    public Boolean bodyContainsNone;

    @JsonProperty("HeadersContain") 
    public Boolean headersContain;

    @JsonProperty("JSONValue") 
    public JSONValue jsonValue;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
*/