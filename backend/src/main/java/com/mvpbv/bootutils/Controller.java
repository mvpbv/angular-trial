package com.mvpbv.bootutils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;



@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final DataService dataService;

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
    @GetMapping("/getStats")
    public JsonNode fetchData() {
        return JsonParser.fetchAggregateStats();
    }
    
    @GetMapping("/getRawData")
    public JsonNode getRawData() {
        return dataService.fetchRawData();
    }
    @GetMapping("/getOopData") 
    public JsonNode getOopData() {
        return dataService.fetchOopData();
    }
    @GetMapping("/getLessonData")
    public JsonNode getLessonData() {
        return dataService.fetchLessonData();
    }
    @GetMapping("/getChallengeData")
    public JsonNode getChallengeData() {
        return dataService.fetchChallengeData();
    }
    
    
}

