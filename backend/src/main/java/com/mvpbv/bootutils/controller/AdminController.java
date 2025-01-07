package com.mvpbv.bootutils.controller;

import com.mvpbv.bootutils.service.ReadmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.mvpbv.bootutils.service.AdminService;
import com.mvpbv.bootutils.service.DataService;


@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    private DataService dataService;
    @Autowired
    private ReadmeService readmeService;

    @GetMapping("/generateDB")
    public String seedDb() {
        adminService.seedCourses();
        adminService.seedRequiredLessons();
        adminService.seedOptionalLessons();
        return "Seeded the database!";
    }
    @GetMapping("/seedLessons")
    public String seedLessons() {
        adminService.seedRequiredLessons();
        return "Seeded the lessons!";
    }
    @GetMapping("/testDb")
    public String testDb() {
        adminService.testDatabaseConnection();
        return "Tested the database!";
    }
    @GetMapping("/seedAnalytics")
    public String seedAnalytics() {
        adminService.seedAnalyticsLessons();
        return "Seeded the analytics!";
    }
    @GetMapping("/seedCode")
    public String seedCode() {
        adminService.seedCodeChallenges();
        return "Seeded the code challenges!";
    }
    @GetMapping("/seedReadmeService")
    public String seedReadme() {
        readmeService.seedReadme();
        readmeService.seedDomains();
        return "Seeded the readme service!";
    }
    @GetMapping("/seedReadme")
    public String seedReadmeOnly() {
        readmeService.seedReadme();
        return "Seeded the readme!";
    }
    @GetMapping("/seedDomains")
    public String seedDomains() {
        readmeService.seedDomains();
        return "Seeded the domains!";
    }

    @GetMapping("/seedCourseInfo")
    public String seedCourseInfo() {
      readmeService.seedCourseInfo();
        return "Seeded the course info!";
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

}

