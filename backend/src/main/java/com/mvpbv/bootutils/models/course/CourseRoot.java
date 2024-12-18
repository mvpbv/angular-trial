package com.mvpbv.bootutils.models.course;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mvpbv.bootutils.models.Root;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity

public class CourseRoot{
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
    @Lob
    @Column(name = "Description", columnDefinition="LONGTEXT")
    private String description;

    @JsonProperty("ThumbnailURL") 
    private String thumbnailURL;

    @JsonProperty("Difficulty") 
    private int difficulty;
    
    @JsonProperty("EstimatedCompletionTimeHours") 
    private int estimatedCompletionTimeHours;
    
    @JsonProperty("TypeDescription") 
    private String typeDescription;
    
    @JsonProperty("LastUpdated") 
    private Date lastUpdated;
    
    @JsonProperty("SlugAliases") 
    @ElementCollection
    private List<String> slugAliases;
    
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

    @ManyToOne
    @JoinColumn(name = "root_id")
    @JsonBackReference
    private Root root;


    public CourseRoot() {
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUUID() {
        return UUID;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenericTitle() {
        return genericTitle;
    }

    public void setGenericTitle(String genericTitle) {
        this.genericTitle = genericTitle;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getEstimatedCompletionTimeHours() {
        return estimatedCompletionTimeHours;
    }

    public void setEstimatedCompletionTimeHours(int estimatedCompletionTimeHours) {
        this.estimatedCompletionTimeHours = estimatedCompletionTimeHours;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<String> getSlugAliases() {
        return slugAliases;
    }

    public void setSlugAliases(List<String> slugAliases) {
        this.slugAliases = slugAliases;
    }

    public Alternatives getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(Alternatives alternatives) {
        this.alternatives = alternatives;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumRequiredLessons() {
        return numRequiredLessons;
    }

    public void setNumRequiredLessons(int numRequiredLessons) {
        this.numRequiredLessons = numRequiredLessons;
    }

    public int getNumOptionalLessons() {
        return numOptionalLessons;
    }

    public void setNumOptionalLessons(int numOptionalLessons) {
        this.numOptionalLessons = numOptionalLessons;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getCompletionXp() {
        return completionXp;
    }

    public void setCompletionXp(int completionXp) {
        this.completionXp = completionXp;
    }

    public int getNumEnrolled() {
        return numEnrolled;
    }

    public void setNumEnrolled(int numEnrolled) {
        this.numEnrolled = numEnrolled;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }
}