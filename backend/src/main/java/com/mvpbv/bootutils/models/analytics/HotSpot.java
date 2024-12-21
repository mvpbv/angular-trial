package com.mvpbv.bootutils.models.analytics;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HotSpot {
    private int sum;
    private List<CodeChallenge> items;

    public HotSpot(int sum, List<CodeChallenge> items) {
        this.sum = sum;
        this.items = items;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
    public List<CodeChallenge> getItems() {
        return items;
    }
    public void setItems(List<CodeChallenge> items) {
        this.items = items;
    }
    @JsonIgnore
    public String getCourseName() {
        return items.get(0).getCourseName();
    }
    @JsonIgnore
    public int getCourseIndex() {
        return items.get(0).getCourseIndex();
    }
    @JsonIgnore
    public AnalyticsCourse getCourse() {
        return new AnalyticsCourse(getCourseName(), getCourseIndex());
    }
    @JsonIgnore
    public int getMinRadix() {
        return items.stream().map(CodeChallenge::getChron).min(Integer::compare).orElse(0);
    }
    @JsonIgnore
    public int getMaxRadix() {
        return items.stream().map(CodeChallenge::getChron).max(Integer::compare).orElse(0);
    }
    @JsonIgnore
    public int[] getRadixRange() {
        return new int[] {getMinRadix(), getMaxRadix()};
    }
    @JsonIgnore
    public Set<CodeChallenge> getSet() {
        return new HashSet<>(items);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotSpot hotSpot = (HotSpot) o;
        return sum == hotSpot.sum && Objects.equals(items, hotSpot.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, items);
    }
}