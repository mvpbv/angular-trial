package com.mvpbv.bootutils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonParser {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static JsonNode cachedData;
    private static final Logger logger = Logger.getLogger(JsonParser.class.getName());

    static {
        try {
            File file = new File("cache.json");
            cachedData = objectMapper.readTree(file);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to read cache.json", e);
        }
    }
    public static JsonNode getCache() {
        return cachedData;
    }
    public static int getCount(JsonNode data) {
        return data.size();
    }
    private static float getMeanDiff(JsonNode data) {
        var count = getCount(data);   
        var total = 0;
        for (JsonNode node : data) {
            if (node.has("Diff")) {
            total += node.get("Diff").asInt();
            }
        }
        float average = (float) total / (float) count;
        return average;
    }
    private static float getMeanReadme(JsonNode data) {
        var count = getCount(data);
        var sum = 0;
        for (JsonNode node : data) {
            if (node.has("ReadmeLen")) {
                sum += node.get("ReadmeLen").asInt();
            }
        }
        float mean = (float) sum / (float) count;
        return mean;
    }
    public static JsonNode getAggregateStats() {
        JsonNode data = getCache();
        var stats = objectMapper.createObjectNode();
        stats.put("count", getCount(data));
        stats.put("average", getMeanDiff(data));
        stats.put("meanReadme", getMeanReadme(data));
        var diffCounts = getDifficultyCounts(data);
        var diffCountsNode = objectMapper.valueToTree(diffCounts);
        stats.set("difficultyCounts", diffCountsNode);
        return objectMapper.valueToTree(stats);
    }
    private static HashMap<String, Integer> getDifficultyCounts(JsonNode data) {
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
    public static JsonNode getCourseList() {
        JsonNode data = getCache();
        var courseList = new HashSet<String>();
        for (JsonNode node : data) {
            var course = node.get("CourseFriendly").asText();
            if (courseList.contains(course)) {
                courseList.add(course);
            } 
        }

        return objectMapper.valueToTree(courseList);
    }

    
}
