package com.mvpbv.bootutils;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

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



    @Autowired
    public DataService() {
        this.lessons = new Lessons();
        this.courses = new Courses();
        this.baseUrl = "https://api.boot.dev/v1/";
        this.lessonUrl = this.baseUrl + "static/lessons/78b4646f-85aa-42c7-ba46-faec2f0902a9";
        this.challengeUrl = this.baseUrl + "static/lessons/451da8ad-f8e9-4a58-88ec-dbfba4f76bb4";
        this.courseUrl = this.baseUrl + "courses/f9a48bbc-d1ff-4388-bf0c-23c6e3c60ae0";

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

}