package com.mvpbv.bootutils.models.analytics;

public class CourseAverages {
    private double average;
    private String courseName;
    private int courseIndex;

    public CourseAverages(double average, String courseName, int courseIndex) {
        this.average = average;
        this.courseName = courseName;
        this.courseIndex = courseIndex;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseIndex() {
        return courseIndex;
    }

    public void setCourseIndex(int courseIndex) {
        this.courseIndex = courseIndex;
    }

}
