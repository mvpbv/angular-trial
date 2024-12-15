package com.mvpbv.bootutils;

import com.fasterxml.jackson.databind.JsonNode;

public class Datapoint {

    public String title;
    public boolean isChallenge;
    public int lessonIndex;
    public int chapterIndex;
    public String chapterName;
    public int courseIndex;
    public String courseName;
    public int trackIndex;
    public int difficulty;
    public int readmeLen;
    public int radix;
        
        public Datapoint(JsonNode value) {
            this.title = value.get("Title").asText();
            this.isChallenge = value.get("Challenge").asBoolean();
            this.lessonIndex = value.get("LeastPriority").asInt();
            this.chapterIndex = value.get("MiddlePriority").asInt();
            this.chapterName = value.get("Chapter").asText();
            this.courseIndex = value.get("HighPriority").asInt();
            this.courseName = value.get("CourseFriendly").asText();
            this.trackIndex = value.get("HighestPriority").asInt();
            this.difficulty = value.get("Diff").asInt();
            this.readmeLen = value.get("ReadmeLen").asInt();
            this.radix = this.assignRadix();
        }
        private int assignRadix() {
            var temp = this.lessonIndex;
            if (this.isChallenge) {
                temp += 30;
            }
            temp += this.chapterIndex * 100;
            temp += this.courseIndex * 1000;
            temp += this.trackIndex * 10000;
            return temp;
        }
    
}
