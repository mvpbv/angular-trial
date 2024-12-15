package com.mvpbv.bootutils;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;




public class Cache {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static JsonNode cachedData;
    private static final Logger logger = Logger.getLogger(Cache.class.getName());


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
    public static JsonNode fetchChronologicalData() {
        return sortChron();
    }
    private static JsonNode sortChron() {
        JsonNode blob = getCache();
        Datapoint[] datapoints = new Datapoint[blob.size()];
        for (int i = 0; i < blob.size(); i++) {
            datapoints[i] = new Datapoint(blob.get(i));
        }
        Arrays.sort(datapoints, (a, b) -> a.radix - b.radix);
        ArrayNode chron = objectMapper.createArrayNode();
        for (int i = 0; i < datapoints.length; i++) {
            ObjectNode node = objectMapper.valueToTree(datapoints[i]);
            node.put("chronIndex", i);
            chron.add(node);
        }
        return chron;
    }
}
