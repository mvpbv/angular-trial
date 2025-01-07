package com.mvpbv.bootutils.models.links;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class CourseInfo {

  private String courseTitle;

  @Id
  private int courseIndex;

  @ManyToOne
  private TrackInfo trackInfo;

  @ManyToMany(mappedBy = "courseInfos")
  private Set<Domain> domains;

  @OneToMany(mappedBy = "courseInfo")
  private List<Readme> readmes;

  @OneToMany(mappedBy = "courseInfo")
  private List<Url> urls;

  public CourseInfo() {}

  public CourseInfo(int courseIndex, String courseTitle, TrackInfo trackInfo) {
    this.courseTitle = courseTitle;
    this.courseIndex = courseIndex;
    this.trackInfo = trackInfo;
  }

  public CourseInfo(String courseTitle, int courseIndex, TrackInfo trackInfo, Set<Domain> domains, List<Readme> readmes, List<Url> urls) {
    this.courseTitle = courseTitle;
    this.courseIndex = courseIndex;
    this.trackInfo = trackInfo;
    this.domains = domains;
    this.readmes = readmes;
    this.urls = urls;
  }

  // Getters and Setters
  public String getCourseTitle() {
    return courseTitle;
  }

  public void setCourseTitle(String courseTitle) {
    this.courseTitle = courseTitle;
  }

  public int getCourseIndex() {
    return courseIndex;
  }

  public void setCourseIndex(int courseIndex) {
    this.courseIndex = courseIndex;
  }
  @JsonIgnore
  public TrackInfo getTrackInfo() {
    return trackInfo;
  }

  public void setTrackInfo(TrackInfo trackInfo) {
    this.trackInfo = trackInfo;
  }
  @JsonIgnore
  public Set<Domain> getDomains() {
    return domains;
  }

  public void setDomains(Set<Domain> domains) {
    this.domains = domains;
  }
  @JsonIgnore
  public List<Readme> getReadmes() {
    return readmes;
  }

  public void setReadmes(List<Readme> readmes) {
    this.readmes = readmes;
  }
  @JsonIgnore
  public List<Url> getUrls() {
    return urls;
  }

  public void setUrls(List<Url> urls) {
    this.urls = urls;
  }


}
