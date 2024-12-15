package com.mvpbv.bootutils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;





@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final DataService dataService;

    public Controller(DataService dataService) {
        this.dataService = dataService;
        
    }

    @GetMapping("/healthz")
    public Map<String, String> healthCheck() {
        var response = new HashMap<String, String>();
        response.put("status", "Ready to go!");
        return response;
    }
    @GetMapping("err")
    public String err() {
        return "Error!";
    }
    @GetMapping("/getStats")
    public JsonNode fetchData() {
        return dataService.fetchAggregateStats();
    }
    @GetMapping("/getData") 
    public JsonNode getData() {
        return Cache.fetchChronologicalData();
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
    @GetMapping("/testReadmeParse")
    public JsonNode testParse() {
        return dataService.testReadmeParse();
    }
    @GetMapping("/goNuts")
    public String goNuts() {
        try {
            TextAnalysis.ProcessDir();
        } catch (IOException e) {
            throw new RuntimeException("Failed to process directory: " + e.getMessage());
        }
        return "Going nuts!";
    }
    @GetMapping("/getAssetUrls") 
    public JsonNode getAssetUrls() {
        return dataService.fetchAssetUrls();
    }
    @GetMapping("/getDomainCount")
    public JsonNode getDomainCount() {
        return dataService.fetchDomainCount();
    }
    @GetMapping("/getDomainTrie")
    public JsonNode getDomainTrie() {
        return dataService.fetchDomainTrie();
    }
}

