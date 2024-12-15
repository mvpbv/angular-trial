package com.mvpbv.bootutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Lessons {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private static final Logger logger = Logger.getLogger(Lessons.class.getName());
    public Lessons() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }
    public JsonNode fetchLessonData(String url) {
        logger.log(Level.INFO, "Making request to {0}", url);
        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        if (response == null) {
            logger.log(Level.WARNING, "Failed to fetch data from {0}", url);
            return null;
        }
        var filteredResponse = new ObjectMapper().createObjectNode();
        filteredResponse = filterLessonResponse(response, filteredResponse);
        var processedResponse = processLesson(filteredResponse);
        processedResponse = parseLessonData(response, processedResponse);
        try {
            File file = new File("l-response.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, response);
            logger.log(Level.INFO, "Full JSON Tree written to response.json:");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to pretty print response", e);
        }
        
        return processedResponse;
    }
    private ObjectNode processLesson(JsonNode lesson) {
        ObjectNode newNode = objectMapper.createObjectNode();
        if (lesson.has("CompletionType")) {
            var challenge = lesson.get("CompletionType").asText().equals("completion_type_challenge");
            newNode.put("Challenge", challenge);
        }
        if (lesson.has("Slug")) {
            String slug = lesson.get("Slug").asText();
            int leastPriority = Integer.parseInt(slug.split("-")[0]);
            newNode.put("LeastPriority", leastPriority);
        }
        if (lesson.has("ChapterSlug")) {
            String chapterSlug = lesson.get("ChapterSlug").asText();
            var split = chapterSlug.split("-");
            int middlePriority = Integer.parseInt(split[0]);
            String chapter = split[1].replace("_", " ");
            chapter = chapter.substring(0, 1).toUpperCase() + chapter.substring(1);

            newNode.put("MiddlePriority", middlePriority);
            newNode.put("Chapter", chapter);
        }
        if (lesson.has("CourseSlug")) {
            switch (lesson.get("CourseSlug").asText()) {
                case "learn-code-python" -> newNode.put("HighPriority", 1);
                case "learn-object-oriented-programming-python" -> newNode.put("HighPriority", 2);
                case "learn-functional-programming-python" -> newNode.put("HighPriority", 3);
                case "learn-algorithms-python" -> newNode.put("HighPriority", 4);
                case "learn-data-structures-python" -> newNode.put("HighPriority", 5);
                case "learn-memory-management-c" -> newNode.put("HighPriority", 6);
                case "learn-golang" -> newNode.put("HighPriority", 7);
                case "learn-http-clients-golang" -> newNode.put("HighPriority", 8);
                case "learn-http-servers-golang" -> newNode.put("HighPriority", 9);
                case "learn-sql" -> newNode.put("HighPriority", 10);
                case "learn-javascript" -> newNode.put("HighPriority", 11);
                case "learn-http-clients-typescript" -> newNode.put("HighPriority", 12);
                case "learn-http-servers-typescript" -> newNode.put("HighPriority", 13);
                case "learn-cryptography-golang" -> newNode.put("HighPriority", 14);
                case "learn-algorithms-2-python" -> newNode.put("HighPriority", 15);

                default -> newNode.put("HighPriority", 1000);
            }
        }
        if (lesson.has("CourseSlug")) {
            switch (lesson.get("CourseSlug").asText()) {
                case "learn-code-python" -> newNode.put("CourseFriendly", "Learn Python");
                case "learn-object-oriented-programming-python" -> newNode.put("CourseFriendly", "Learn OOP");
                case "learn-functional-programming-python" -> newNode.put("CourseFriendly", "Learn FP");
                case "learn-algorithms-python" -> newNode.put("CourseFriendly", "Learn Algorithms");
                case "learn-data-structures-python" -> newNode.put("CourseFriendly", "Learn Data Structures");
                case "learn-memory-management-c" -> newNode.put("CourseFriendly", "C Memory Management");
                case "learn-golang" -> newNode.put("CourseFriendly", "Learn Go");
                case "learn-http-clients-golang" -> newNode.put("CourseFriendly", "Go HTTP Clients");
                case "learn-javascript" -> newNode.put("CourseFriendly", "Learn JavaScript");
                case "learn-http-clients-typescript" -> newNode.put("CourseFriendly", "TS HTTP Clients");
                case "learn-http-servers-golang" -> newNode.put("CourseFriendly", "Go Web Servers");
                case "learn-http-servers-typescript" -> newNode.put("CourseFriendly", "TS Web Servers");
                case "learn-sql" -> newNode.put("CourseFriendly", "Learn SQL");
                case "learn-cryptography-golang" -> newNode.put("CourseFriendly", "Go Cryptography");
                case "learn-algorithms-2-python" -> newNode.put("CourseFriendly", "Adv Algorithms");

                default -> newNode.put("CourseFriendly", 1000);
            }
        }
        if (lesson.has("CourseSlug")) {
            switch (lesson.get("CourseSlug").asText()) {
                case "learn-code-python" -> newNode.put("HighestPriority", 1);
                case "learn-object-oriented-programming-python" -> newNode.put("HighestPriority", 1);
                case "learn-functional-programming-python" -> newNode.put("HighestPriority", 1);
                case "learn-algorithms-python" -> newNode.put("HighestPriority", 1);
                case "learn-data-structures-python" -> newNode.put("HighestPriority", 1);
                case "learn-memory-management-c" -> newNode.put("HighestPriority", 1);
                case "learn-golang" -> newNode.put("HighestPriority", 2);
                case "learn-http-clients-golang" -> newNode.put("HighestPriority", 2);
                case "learn-javascript" -> newNode.put("HighestPriority", 3);
                case "learn-http-clients-typescript" -> newNode.put("HighestPriority", 3);
                case "learn-http-servers-golang" -> newNode.put("HighestPriority", 2);
                case "learn-http-servers-typescript" -> newNode.put("HighestPriority", 3);
                case "learn-sql" -> newNode.put("HighestPriority", 2);
                case "learn-cryptography-golang" -> newNode.put("HighestPriority", 3);
                case "learn-algorithms-2-python" -> newNode.put("HighestPriority", 3);

                default -> newNode.put("HighestPriority", "1000");
            }
        }
        if (lesson.has("CourseSlug")) {
            switch (lesson.get("CourseSlug").asText()) {
                case "learn-code-python" -> newNode.put("TrackFriendly", "CS Fundamentals");
                case "learn-object-oriented-programming-python" -> newNode.put("TrackFriendly", "CS Fundamentals");
                case "learn-functional-programming-python" -> newNode.put("TrackFriendly", "CS Fundamentals");
                case "learn-algorithms-python" -> newNode.put("TrackFriendly", "CS Fundamentals");
                case "learn-data-structures-python" -> newNode.put("TrackFriendly", "CS Fundamentals");
                case "learn-memory-management-c" -> newNode.put("TrackFriendly", "CS Fundamentals");
                case "learn-golang" -> newNode.put("TrackFriendly", "Backend Go");
                case "learn-http-clients-golang" -> newNode.put("TrackFriendly", "Backend Go");
                case "learn-javascript" -> newNode.put("TrackFriendly", "Backend TS");
                case "learn-http-clients-typescript" -> newNode.put("TrackFriendly", "Backend TS");
                case "learn-http-servers-golang" -> newNode.put("TrackFriendly", "Backend Go");
                case "learn-http-servers-typescript" -> newNode.put("TrackFriendly", "Backend Go");
                case "learn-sql" -> newNode.put("TrackFriendly", "Backend Track");
                case "learn-cryptography-golang" -> newNode.put("TrackFriendly", "Deeper Learning");
                case "learn-algorithms-2-python" -> newNode.put("TrackFriendly", "Deeper Learning");
                default -> newNode.put("TrackFriendly", "Unknown");
            }
        }
        if (lesson.has("CourseSlug")) {
            switch (lesson.get("CourseSlug").asText()) {
                case "learn-code-python" -> newNode.put("Language", "Python");
                case "learn-object-oriented-programming-python" -> newNode.put("Language", "Python");
                case "learn-functional-programming-python" -> newNode.put("Language", "Python");
                case "learn-algorithms-python" -> newNode.put("Language", "Python");
                case "learn-data-structures-python" -> newNode.put("Language", "Python");
                case "learn-memory-management-c" -> newNode.put("Language", "C");
                case "learn-golang" -> newNode.put("Language", "Golang");
                case "learn-http-clients-golang" -> newNode.put("Language", "Golang");
                case "learn-javascript" -> newNode.put("Language", "JavaScript");
                case "learn-http-clients-typescript" -> newNode.put("Language", "TypeScript");
                case "learn-http-servers-golang" -> newNode.put("Language", "Golang");
                case "learn-http-servers-typescript" -> newNode.put("Language", "TypeScript");
                case "learn-sql" -> newNode.put("Language", "SQL");
                case "learn-cryptography-golang" -> newNode.put("Language", "Golang");
                case "learn-algorithms-2-python" -> newNode.put("Language", "Python");

                default -> newNode.put("course", "Unknown");
            }
        }


        if (lesson.has("Difficulty")) {
            newNode.set("Diff", lesson.get("Difficulty"));
        }
        if (lesson.has("Title")) {
            newNode.set("Title", lesson.get("Title"));
        }
        return newNode;
    }

    private ObjectNode filterLessonResponse(JsonNode response, ObjectNode filtered ) {
        if (response.has("LessonDifficulty")) {
            filtered.set("Difficulty", response.get("LessonDifficulty"));
        }
        if (response.has("Lesson")) {
            JsonNode lesson = response.get("Lesson");
            filtered.set("Slug", lesson.get("Slug"));
            filtered.set("ChapterSlug", lesson.get("ChapterSlug"));
            filtered.set("Title", lesson.get("Title"));
            filtered.set("CourseSlug", lesson.get("CourseSlug"));
            filtered.set("CompletionType", lesson.get("CompletionType"));
            
        }

        return filtered;
    }
    private ObjectNode parseLessonData(JsonNode response, ObjectNode filtered) {
        if (response.has("Lesson")) {
            JsonNode lesson = response.get("Lesson");
            String uuid = "";
            if (lesson.has("UUID")) {
                uuid = lesson.get("UUID").asText();
                filtered.put("UUID", lesson.get("UUID").asText());
            }
            if (lesson.has("LessonDataCodeCompletion")) {
                JsonNode codeCompletion = lesson.get("LessonDataCodeCompletion");
                if (codeCompletion.has("Readme")) {
                    String readme = codeCompletion.get("Readme").asText();
                    saveParsed(readme, uuid);
                    filtered.put("ReadmeLen", readme.length());
                }       
            }
            if (lesson.has("LessonDataCodeCompletionSQL")) {
                JsonNode codeCompletionSQL = lesson.get("LessonDataCodeCompletionSQL");
                if (codeCompletionSQL.has("Readme")) {
                    String readme = codeCompletionSQL.get("Readme").asText();
                    saveParsed(readme, uuid);
                    filtered.put("ReadmeLen", readme.length());
                }       
            }
            if (lesson.has("LessonDataCodeTests")) {
                JsonNode codeTests = lesson.get("LessonDataCodeTests");
                if (codeTests.has("Readme")) {
                    String readme = codeTests.get("Readme").asText();
                    saveParsed(readme, uuid);
                    filtered.put("ReadmeLen", readme.length());
                }       
            }
            if (lesson.has("LessonDataHTTPTests")) {
                JsonNode httpTests = lesson.get("LessonDataHTTPTests");
                if (httpTests.has("Readme")) {
                    String readme = httpTests.get("Readme").asText();
                    saveParsed(readme, uuid);
                    filtered.put("ReadmeLen", readme.length());
                }       
            }
    }
        return filtered;
    }
    public void saveParsed(String readme, String uuid) {
        try (FileWriter writer = new FileWriter("assets/" + uuid + ".md", true)) {
            writer.write(readme);
            logger.log(Level.INFO, "Stored readme");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Lost a readme", e);
            throw new RuntimeException("Failed to write readme");
        }
    }
}
