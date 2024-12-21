package com.mvpbv.bootutils.models.analytics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LegacyHotSpot {
    private int sum;
    private AnalyticsLesson[] items;

    public LegacyHotSpot(int sum, AnalyticsLesson[] items) {
        this.sum = sum;
        this.items = items;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public AnalyticsLesson[] getItems() {
        return items;
    }
    public void setItems(AnalyticsLesson[] items) {
        this.items = items;
    }
    @JsonIgnore
    public String getCourseName() {
        return items[0].getCourseName();
    }
    @JsonIgnore
    public int getCourseIndex() {
        return items[0].getCourseIndex();
    }
    @JsonIgnore
    public AnalyticsCourse getCourse() {
        return new AnalyticsCourse(getCourseName(), getCourseIndex());
    }
    @JsonIgnore
    public int getMinRadix() {
        return Arrays.asList(items).stream().map(AnalyticsLesson::getRadix).min(Integer::compare).orElse(0);
    }
    @JsonIgnore
    public int getMaxRadix() {
        return Arrays.asList(items).stream().map(AnalyticsLesson::getRadix).max(Integer::compare).orElse(0);
    }
    @JsonIgnore
    public int[] getRadixRange() {
        return new int[] {getMinRadix(), getMaxRadix()};
    }
    @JsonIgnore
    public Set<AnalyticsLesson> getSet() {
        return new HashSet<>(Arrays.asList(items));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegacyHotSpot hotSpot = (LegacyHotSpot) o;
        return sum == hotSpot.getSum() && Arrays.equals(items, hotSpot.getItems());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sum);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }
}