package com.mvpbv.bootutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

@RestController
@RequestMapping("/api/v1")
public class Controller {
    private static final Logger logger = Logger.getLogger(Controller.class.getName());

    private final DataService dataService;
    private final String baseUrl = "https://api.boot.dev/v1/";
    private final ObjectMapper ObjectMapper = new ObjectMapper();

    @Autowired
    public Controller(DataService dataService) {
        this.dataService = dataService;
        
    }

    @RequestMapping("/healthz")
    public Map<String, String> healthCheck() {
        var response = new HashMap<String, String>();
        response.put("status", "Ready to go!");
        return response;
    }
    @RequestMapping("err")
    public String err() {
        return "Error!";
    }
    @GetMapping("/fetchData")
    public JsonNode fetchData() {
        ArrayList<String> courseList = new ArrayList<>();
        courseList.add("courses/f9a25dfb-3e00-4727-ac78-36de82315355");
        courseList.add("courses/f9a48bbc-d1ff-4388-bf0c-23c6e3c60ae0");
        courseList.add("courses/b1459f0c-21eb-41e5-b7f3-562ef69d344c");
        courseList.add("courses/884342fc-5469-47b4-8125-8bfc897428a8");
        courseList.add("courses/7bbb53ed-2106-4f6b-b885-e7645c2ff9d8");
        
        ArrayNode lessons = ObjectMapper.createArrayNode();

        for (String course : courseList) {
            String url = baseUrl + course;
            logger.log(Level.INFO, "Fetching data from {0}", url);
            lessons.add(dataService.fetchCourseData(url));
            logger.log(Level.INFO, "Data fetched successfully");
        }
        return lessons;
    }
    @GetMapping("/fetchOopData") 
    public JsonNode fetchOopData() {
        String url = "https://api.boot.dev/v1/courses/f9a48bbc-d1ff-4388-bf0c-23c6e3c60ae0";
        logger.log(Level.INFO, "Fetching data from {0}", url);
        JsonNode data = dataService.fetchCourseData(url);
        logger.log(Level.INFO, "Data fetched successfully for OOP");
        return data;
    }
    @GetMapping("/fetchLessonData")
    public JsonNode fetchLessonData() {
        String url = "https://api.boot.dev/v1/static/lessons/451da8ad-f8e9-4a58-88ec-dbfba4f76bb4";
        logger.log(Level.INFO, "Fetching data from {0}", url);
        JsonNode data = dataService.fetchLessonData(url);
        logger.log(Level.INFO, "Data fetched successfully");
        return data;
    }
    
    
}

