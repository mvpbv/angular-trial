package com.mvpbv.bootutils.models.analytics;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HotSpot {
    private int sum;

    private List<CodeChallenge> items;

    private Set<String> courses;
    
    private Set<String> chapters;

    private int[] chronRange;

    private int[] difficultyRange;
    

    
    public HotSpot(int sum, List<CodeChallenge> items) {
        this.sum = sum;
        this.items = items;
        this.courses = new HashSet<>(items.stream().map(CodeChallenge::getCourseName).toList());
        this.chapters = new HashSet<>(items.stream().map(CodeChallenge::getChapterName).toList());
        this.chronRange = findChronRange(items);
        this.difficultyRange = findDifficultyRange(items);
    }
    private int[] findChronRange(List<CodeChallenge> items) {
        return new int[] {findChronMin(items), findChronMax(items)};
    }
    private int[] findDifficultyRange(List<CodeChallenge> items) {
        return new int[] {findDifficultyMin(items), findDifficultyMax(items)};
    }

    private int findChronMin(List<CodeChallenge> items) {
        return items.stream()
                    .map(CodeChallenge::getChron)
                    .min(Integer::compare)
                    .orElse(0);
    }
    private int findChronMax(List<CodeChallenge> items) {
        return items.stream()
                    .map(CodeChallenge::getChron)
                    .max(Integer::compare)
                    .orElse(0);
    }
    private int findDifficultyMin(List<CodeChallenge> items) {
        return items.stream()
                    .map(CodeChallenge::getDifficulty)
                    .min(Integer::compare)
                    .orElse(0);
    }
    private int findDifficultyMax(List<CodeChallenge> items) {
        return items.stream()
                    .map(CodeChallenge::getDifficulty)
                    .max(Integer::compare)
                    .orElse(0);
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
    public int getMinChron() {
        return chronRange[0];
    }
    @JsonIgnore
    public int getMaxChron() {
        return chronRange[1];
    }

    @JsonIgnore
    public Set<CodeChallenge> getSet() {
        return new HashSet<>(items);
    }

    public Set<String> getcourses() {
        return courses;
    }

    public void setcourses(Set<String> courses) {
        this.courses = courses;
    }

    public Set<String> getchapters() {
        return chapters;
    }

    public void setchapters(Set<String> chapters) {
        this.chapters = chapters;
    }

    public int[] getChronRange() {
        return chronRange;
    }

    public void setChronRange(int[] chronRange) {
        this.chronRange = chronRange;
    }

    public int[] getDifficultyRange() {
        return difficultyRange;
    }

    public void setDifficultyRange(int[] difficultyRange) {
        this.difficultyRange = difficultyRange;
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