package com.mvpbv.bootutils.models.analytics;


public class HotSpot {
    private int sum;
    private AnalyticsLesson[] spotArray;

    public HotSpot(int sum, AnalyticsLesson[] spotArray) {
        this.sum = sum;
        this.spotArray = spotArray;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public AnalyticsLesson[] getSpotArray() {
        return spotArray;
    }
    public void setSpotArray(AnalyticsLesson[] spotArray) {
        this.spotArray = spotArray;
    }
    public String getCourseName() {
        return spotArray[0].getCourseName();
    }
    public int getCourseIndex() {
        return spotArray[0].getCourseIndex();
    }
    public AnalyticsCourse getCourse() {
        return new AnalyticsCourse(getCourseName(), getCourseIndex());
    }

}