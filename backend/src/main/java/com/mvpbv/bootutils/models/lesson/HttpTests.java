package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class HttpTests {
    @JsonProperty("BaseURL") 
    public String baseURL;
    @JsonProperty("Requests") 
    public List<Request> requests;
    @JsonProperty("ContainsCompleteDir") 
    public boolean containsCompleteDir;
}