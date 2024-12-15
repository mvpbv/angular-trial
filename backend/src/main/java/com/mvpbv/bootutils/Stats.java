package com.mvpbv.bootutils;

import java.util.HashMap;


import com.fasterxml.jackson.databind.JsonNode;

public class Stats {

    public static HashMap<String, Integer> getDifficultyCounts(JsonNode data) {
        var difficultyCounts = new HashMap<String, Integer>();
        for (JsonNode node : data) {
            if (node.has("Difficulty")) {
            var difficulty = node.get("Difficulty").asText();
            if (difficultyCounts.containsKey(difficulty)) {
                difficultyCounts.put(difficulty, difficultyCounts.get(difficulty) + 1);
            } else {
                difficultyCounts.put(difficulty, 1);
            }
        }
        }
        return difficultyCounts;
    }
    public static HashMap<String, Integer> getCourseCounts(JsonNode data) {
        var courseCounts = new HashMap<String, Integer>();
        for (JsonNode node : data) {
            var course = node.get("CourseFriendly").asText();
            if (courseCounts.containsKey(course)) {
                courseCounts.put(course, courseCounts.get(course) + 1);
            } else {
                courseCounts.put(course, 1);
            }
        }
        return courseCounts;
    }
    public static float getMeanReadme(JsonNode data) {
        var count = Cache.getCount(data);
        var sum = 0;
        for (JsonNode node : data) {
            if (node.has("ReadmeLen")) {
                sum += node.get("ReadmeLen").asInt();
            }
        }
        float mean = (float) sum / (float) count;
        return mean;
    }



    public static float getMeanDiff(JsonNode data) {
        var count = Cache.getCount(data);   
        var total = 0;
        for (JsonNode node : data) {
            if (node.has("Diff")) {
            total += node.get("Diff").asInt();
            }
        }
        float average = (float) total / (float) count;
        return average;
    }

}
