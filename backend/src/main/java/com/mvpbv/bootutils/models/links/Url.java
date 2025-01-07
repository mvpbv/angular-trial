package com.mvpbv.bootutils.models.links;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "readme_uuid")
    private Readme readme;

    private String url;

    @ManyToOne
    private Domain domain;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseInfo courseInfo;

    public Url() {
    }
    public Url(String url, Readme readme) {
        this.url = url;
        this.readme = readme;
        this.courseInfo = readme.getCourseInfo();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @JsonIgnore
    public Readme getReadme() {
        return readme;
    }

    public void setReadme(Readme readme) {
        this.readme = readme;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }
    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url obj = (Url) o;
        return this.getUrl().equals(obj.getUrl());
    }
    @Override
    public int hashCode() {
        return this.getUrl().hashCode();
    }

}
