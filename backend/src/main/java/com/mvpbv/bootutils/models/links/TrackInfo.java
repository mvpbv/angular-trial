package com.mvpbv.bootutils.models.links;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class TrackInfo {

    @Id
    private int trackIndex;

    private String trackTitle;

    @OneToMany(mappedBy = "trackInfo")
    private List<CourseInfo> courseInfos;

    public TrackInfo() {
    }
    public TrackInfo(int trackIndex, String trackTitle) {
        this.trackIndex = trackIndex;
        this.trackTitle = trackTitle;
    }

    public int getTrackIndex() {
        return trackIndex;
    }
    public void setTrackIndex(int trackIndex) {
        this.trackIndex = trackIndex;
    }
    public String getTrackTitle() {
        return trackTitle;
    }
    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }
    public List<CourseInfo> getCourseInfos() {
        return courseInfos;
    }
    public void setCourseInfos(List<CourseInfo> courseInfos) {
      this.courseInfos = courseInfos;
    }


}
