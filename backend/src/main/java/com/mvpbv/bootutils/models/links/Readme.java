
package com.mvpbv.bootutils.models.links;

import java.util.List;

import com.mvpbv.bootutils.dto.ReadmeDTO;

import com.mvpbv.bootutils.service.ReadmeService;
import jakarta.persistence.*;

@Entity
public class Readme {

    @Lob
    @Column(name = "readme", columnDefinition="LONGTEXT")
    private String readme;

    @Id
    private String lessonUuid;

    private int length;

    @OneToMany(mappedBy = "readme", cascade=CascadeType.ALL)
    private List<Url> urls;

    @ManyToOne
    private CourseInfo courseInfo;

    public Readme() {

    }
    public Readme(String readme, String uuid, int length) {
        this.readme = readme;
        this.lessonUuid = uuid;
        this.length = length;
    }
    public Readme(ReadmeDTO readmeDTO, CourseInfo courseInfo) {
      this.readme = readmeDTO.getDescription();
      this.lessonUuid = readmeDTO.getUuid();
      this.length = this.readme.length();
      this.courseInfo = courseInfo;
    }


    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }


  public CourseInfo getCourseInfo() {
    return courseInfo;
  }

  public void setCourseInfo(CourseInfo courseInfo) {
    this.courseInfo = courseInfo;
  }

  public String getLessonUuid() {
    return lessonUuid;
  }

  public void setLessonUuid(String lessonUuid) {
    this.lessonUuid = lessonUuid;
  }
}
