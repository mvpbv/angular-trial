package com.mvpbv.bootutils.models.links;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String domain;

    @OneToMany(mappedBy = "domain", cascade=CascadeType.ALL)
    private List<Url> urls;

    @ManyToMany
    @JoinTable(name = "domain_course",
            joinColumns = @JoinColumn(name = "domain_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<CourseInfo> courseInfos;

    private int count;

    public Domain(String domain) {
        this.domain = domain;
    }

    public Domain() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    @JsonIgnore
    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

  public Set<CourseInfo> getCourseInfos() {
    return courseInfos;
  }

  public void setCourseInfos(Set<CourseInfo> courseInfos) {
    this.courseInfos = courseInfos;
  }
}

