/*
package com.mvpbv.bootutils.models.lesson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "requests")
@Getter @Setter @NoArgsConstructor
public class Request{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request2_id")
    @JsonProperty("Request") 
    public Request2 request2;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="request")
    @JsonProperty("Tests") 
    public List<Test> tests;

    @JsonProperty("ResponseVariables") 
    public String responseVariables;

    @ManyToOne
    private HttpTests httpTests;
}
*/
