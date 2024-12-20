/*
package com.mvpbv.bootutils.models.lesson;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "request2")
@Getter @Setter @NoArgsConstructor
public class Request2{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonProperty("Method") 
    private String method;

    @JsonProperty("Path") 
    private String path;

    @JsonProperty("BasicAuth") 
    private String basicAuth;

    @Embedded
    @JsonProperty("BodyJSON") 
    private BodyJson bodyJson;

    @JsonProperty("Headers") 
    private Headers headers;

    @Embedded
    @JsonProperty("Actions")     
    private Actions actions;

    @OneToOne(mappedBy="request2")
    private Request request;
}
*/