package com.mvpbv.bootutils.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Root{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("UUID") 
    private String UUID;

    @JsonProperty("Slug") 
    private String slug;

    @JsonProperty("Title") 
    private String title;

    @JsonProperty("GenericTitle") 
    private String genericTitle;

    @JsonProperty("ShortDescription") 
    private String shortDescription;

    @JsonProperty("Description") 
    private String description;

    @JsonProperty("ThumbnailURL") 
    private String thumbnailURL;

    @JsonProperty("Difficulty") 
    private int difficulty;

    
    @JsonProperty("PrerequisiteCourseUUIDS") 
    @ElementCollection
    private List<String> prerequisiteCourseUUIDS;
    
    @JsonProperty("EstimatedCompletionTimeHours") 
    private int estimatedCompletionTimeHours;
    
    @JsonProperty("TypeDescription") 
    private String typeDescription;
    
    @JsonProperty("LastUpdated") 
    private Date lastUpdated;
    
    @JsonProperty("SlugAliases") 
    @ElementCollection
    private List<String> slugAliases;
    
    @JsonProperty("AuthorUUIDs") 
    @ElementCollection
    private List<String> authorUUIDs;
    
    @JsonProperty("MaintainerUUIDs")
    @ElementCollection
    private List<String> maintainerUUIDs;
    
    @JsonProperty("Alternatives")
    @Embedded 
    private Alternatives alternatives;
    
    @JsonProperty("Status") 
    private String status;
    
    @JsonProperty("NumRequiredLessons") 
    private int numRequiredLessons;
    
    @JsonProperty("NumOptionalLessons") 
    private int numOptionalLessons;
    
    @JsonProperty("Chapters") 
    @ElementCollection
    @OneToMany(mappedBy = "root", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;

    @JsonProperty("Language") 
    private String language;

    @JsonProperty("CompletionXp") 
    private int completionXp;

    @JsonProperty("NumEnrolled") 
    private int numEnrolled;
}