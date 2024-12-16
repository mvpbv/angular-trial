package com.mvpbv.bootutils.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.mvpbv.bootutils.Cache;
import com.mvpbv.bootutils.Stats;
import com.mvpbv.bootutils.UrlProcessor;

@Service
public class DataService {


    private final Courses courses;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final Lessons lessons;
    private static final Logger logger = Logger.getLogger(DataService.class.getName());
    private final String baseUrl;
    private final String lessonUrl;
    private final String courseUrl;
    private final String challengeUrl;
    private final RestTemplate restTemplate;
    private final String randUrl;

    public DataService(RestTemplate restTemplate, Courses courses, Lessons lessons) {
        this.lessons = lessons;
        this.courses = courses;
        this.baseUrl = "https://api.boot.dev/v1/";
        this.lessonUrl = this.baseUrl + "static/lessons/78b4646f-85aa-42c7-ba46-faec2f0902a9";
        this.challengeUrl = this.baseUrl + "static/lessons/451da8ad-f8e9-4a58-88ec-dbfba4f76bb4";
        this.courseUrl = this.baseUrl + "courses/f9a48bbc-d1ff-4388-bf0c-23c6e3c60ae0";
        this.randUrl = this.baseUrl + "b0807eaa-38e5-4d3f-8359-ffe5e1c9ae7e";
        this.restTemplate = restTemplate;


    }
    public JsonNode fetchAggregateStats() {
        JsonNode data = Cache.getCache();
        var finalStats = objectMapper.createObjectNode();
        finalStats.put("count", Cache.getCount(data));
        finalStats.put("average", Stats.getMeanDiff(data));
        finalStats.put("meanReadme", Stats.getMeanReadme(data));
        var diffCounts = Stats.getDifficultyCounts(data);
        var diffCountsNode = objectMapper.valueToTree(diffCounts);
        var courseCounts = Stats.getCourseCounts(data);
        var courseCountsNode = objectMapper.valueToTree(courseCounts);
        finalStats.set("difficultyCounts", diffCountsNode);
        finalStats.set("courseCounts", courseCountsNode);
        return objectMapper.valueToTree(finalStats);
    }


    public JsonNode fetchLessonData() {
        logger.log(Level.INFO, "Fetching data from {0}", lessonUrl);
        JsonNode data = lessons.fetchLessonData(lessonUrl);
        logger.log(Level.INFO, "Data fetched successfully");
        return data;
    }
    public JsonNode fetchRawData() {
        ArrayList<String> courseList = new ArrayList<>();
        courseList.add("courses/f9a25dfb-3e00-4727-ac78-36de82315355");
        courseList.add("courses/f9a48bbc-d1ff-4388-bf0c-23c6e3c60ae0");
        courseList.add("courses/b1459f0c-21eb-41e5-b7f3-562ef69d344c");
        courseList.add("courses/884342fc-5469-47b4-8125-8bfc897428a8");
        courseList.add("courses/7bbb53ed-2106-4f6b-b885-e7645c2ff9d8");
        courseList.add("courses/8926592f-99b6-4398-a02f-f52e20677f64");
        courseList.add("courses/2af5c197-21eb-48b4-bd90-b0d59adb311e");
        courseList.add("courses/3b39d0f6-f944-4f1b-832d-a1daba32eda4");
        courseList.add("courses/323f2bff-0ba4-4ae9-b617-33bc5b2b7d79");
        courseList.add("courses/5d804c54-887a-4c1c-b8c7-b6436f3a132e");
        courseList.add("courses/bc0dc34b-025a-4d97-b7a0-382aa21533aa");
        courseList.add("courses/81b7293c-60aa-40c7-a158-7c87428f6031");
        courseList.add("courses/ff177b31-d95b-4617-a6d3-db9007569db6");
        courseList.add("courses/aaad49fb-0dc5-43c6-992c-96d3f83ee663");
        courseList.add("courses/6321ddbf-49eb-4748-9737-6bc12e8bb705");
        
        ArrayNode newLessons = objectMapper.createArrayNode();

        for (String course : courseList) {
            String url = baseUrl + course;
            logger.log(Level.INFO, "Fetching data from {0}", url);
            JsonNode courseData = courses.fetchCourseData(url);
            if (courseData.isArray()) {
                for (JsonNode lesson : courseData) {
                    newLessons.add(lesson);
                }
            }
            logger.log(Level.INFO, "Data fetched successfully");
        }
        
        return newLessons;
    }
    public JsonNode fetchChallengeData() {
        JsonNode data = lessons.fetchLessonData(this.challengeUrl);
        logger.log(Level.INFO, "Data fetched successfully");
        return data;
    }
    public JsonNode fetchOopData() {
        logger.log(Level.INFO, "Fetching data from {0}", this.courseUrl);
        JsonNode data = courses.fetchCourseData(this.courseUrl);
        logger.log(Level.INFO, "Data fetched successfully for OOP");
        return data;
    }
    public JsonNode fetchAssetUrls() {
        var list = UrlProcessor.getAssetUrls();
        return objectMapper.valueToTree(list);
    }
    public JsonNode fetchDomainTrie() {
        var list = UrlProcessor.getAssetUrls();
        var domainTrie = UrlProcessor.getDomainTrie(list);
        return objectMapper.valueToTree(domainTrie);
    }
    public JsonNode fetchDomainCount() {
        var list = UrlProcessor.getAssetUrls();
        var domainCount = UrlProcessor.getDomainCount(list);
        return objectMapper.valueToTree(domainCount);
    }

    public JsonNode testReadmeParse() {
        String[] urls = new String[] {this.randUrl, this.challengeUrl};
        var res = objectMapper.createObjectNode();
        for (String url : urls) {
            logger.log(Level.INFO, "Fetching data from {0}", url);
            JsonNode response = restTemplate.getForObject(this.challengeUrl, JsonNode.class);
            if (response == null) {
                logger.log(Level.WARNING, "Failed to fetch data from {0}", this.challengeUrl);
                return null;
            }
            if (response.has("Lesson")) {
                JsonNode lesson = response.get("Lesson");
                if (lesson.has("LessonDataCodeTests")) {
                    JsonNode lessonData = lesson.get("LessonDataCodeTests");
                    if (lessonData.has("Readme")) {
                        if (lessonData.get("Readme") == null) {
                            logger.log(Level.WARNING, "Readme is null");
                            return null;
                        }
                        if (!lessonData.get("Readme").isTextual()) {
                            logger.log(Level.WARNING, "Readme is not textual");
                            return null;
                        }
                        JsonNode readme = lessonData.get("Readme");
                        try (FileWriter writer = new FileWriter("mock.txt", true)) {
                            writer.write(readme.asText());
                            logger.log(Level.INFO, "Readme written to file successfully");
                        } catch (IOException e) {
                            logger.log(Level.SEVERE, "Failed to write Readme to file", e);
                        }
                        logger.log(Level.INFO, "Readme fetched successfully", readme);
                        String[] split = readme.asText().split("##");
                        try (FileWriter writer = new FileWriter("bofa.txt")) {
                            for (String line : split) {
                                writer.write(line + System.lineSeparator());
                            }
                            logger.log(Level.INFO, "Readme written to file successfully");
                        } catch (IOException e) {
                            logger.log(Level.SEVERE, "Failed to write Readme to file", e);
                        }
                    
                    } else {
                        logger.log(Level.WARNING, "Failed to parse data at node Readme");
                    }
                } else if (lesson.has("LessonDataCodeCompletion")) {
                    JsonNode lessonData = lesson.get("LessonDataCodeCompletion");
                    if (lessonData.has("Readme")) {
                        if (lessonData.get("Readme") == null) {
                            logger.log(Level.WARNING, "Readme is null");
                            return null;
                        }
                        if (!lessonData.get("Readme").isTextual()) {
                            logger.log(Level.WARNING, "Readme is not textual");
                            return null;
                        }
                        JsonNode readme = lessonData.get("Readme");
                        try (FileWriter writer = new FileWriter("mock.txt", true)) {
                            writer.write(readme.asText());
                            logger.log(Level.INFO, "Readme written to file successfully");
                        } catch (IOException e) {
                            logger.log(Level.SEVERE, "Failed to write Readme to file", e);
                        }
                        logger.log(Level.INFO, "Readme fetched successfully", readme);
                        String[] split = readme.asText().split("##");
                        try (FileWriter writer = new FileWriter("bofa.txt")) {
                            for (String line : split) {
                                writer.write(line + System.lineSeparator());
                            }
                            logger.log(Level.INFO, "Readme written to file successfully");
                        } catch (IOException e) {
                            logger.log(Level.SEVERE, "Failed to write Readme to file", e);
                        }
                    
                    } else {
                        logger.log(Level.WARNING, "Failed to parse data at node Readme");
                    }
                } else if (lesson.has("LessonDataCodeCompletionSql")) {
                    var lessonData = lesson.get("LessonDataCodeCompletionSql");
                    if (lessonData.has("Readme")) {
                        if (lessonData.get("Readme") == null) {
                            logger.log(Level.WARNING, "Readme is null");
                            return null;
                        }
                        if (!lessonData.get("Readme").isTextual()) {
                            logger.log(Level.WARNING, "Readme is not textual");
                            return null;
                        }
                        JsonNode readme = lessonData.get("Readme");
                        try (FileWriter writer = new FileWriter("mock.txt", true)) {
                            writer.write(readme.asText());
                            logger.log(Level.INFO, "Readme written to file successfully");
                        } catch (IOException e) {
                            logger.log(Level.SEVERE, "Failed to write Readme to file", e);
                        }
                        logger.log(Level.INFO, "Readme fetched successfully", readme);
                        String[] split = readme.asText().split("##");
                        try (FileWriter writer = new FileWriter("bofa.txt")) {
                            for (String line : split) {
                                writer.write(line + System.lineSeparator());
                            }
                            logger.log(Level.INFO, "Readme written to file successfully");
                        } catch (IOException e) {
                            logger.log(Level.SEVERE, "Failed to write Readme to file", e);
                        }
                    
                    } else {
                        logger.log(Level.WARNING, "Failed to parse data at node Readme");
                    }
                } else {
                    logger.log(Level.WARNING, "Failed to parse data at node LesonDataCodeTests");
                }
            } else {
                logger.log(Level.WARNING, "Failed to parse data at node lesson");
            }
        }
        return res;
    }
}