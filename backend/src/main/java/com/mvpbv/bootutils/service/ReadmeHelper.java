package com.mvpbv.bootutils.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mvpbv.bootutils.models.links.CourseInfo;
import com.mvpbv.bootutils.models.links.TrackInfo;
import org.springframework.stereotype.Component;

import com.mvpbv.bootutils.models.links.Readme;
import com.mvpbv.bootutils.models.links.Url;

@Component
public class ReadmeHelper {

    private static final Set<String> ignoredDomains = Set.of("localhost", "storage.googleapis.com", "127.0.0.1", "example.com", "uc.a.run.app", ":8080");


    public String parseDomain(String url) {
        url = url.replace("https://", "");
        url = url.replace("http://", "");
        url = url.replace("www.", "");
        url = url.split("/")[0];
        return url;
    }
    public List<Url> parseUrls(Readme readme) {
        var urlPattern = "https?://\\S+";
        var text = readme.getReadme();
        var matcher = java.util.regex.Pattern.compile(urlPattern).matcher(text);
        List<Url> urls = new ArrayList<>();
        while (matcher.find()) {
            var tempUrl = matcher.group();
            if (ignoredDomains.stream().anyMatch(tempUrl::contains)) {
                continue;
            }
            var cleaned = cleanMatch(matcher.group());
            if (cleaned.contains(">") || cleaned.contains("<")) continue;
            var obj = new Url(cleaned, readme);
            urls.add(obj);

        }
        return urls;
    }
    public String cleanMatch(String match) {
        match = match.replaceAll("[`'\"*{}]", "");
        match = match.split("]\\(")[0];
        match = match.endsWith(".") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith(",") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith("!") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith(":") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith(")") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith(">") ? match.substring(0, match.length() - 1) : match;
        return match;
    }
    public List<TrackInfo> buildTrackInfo() {
      return new ArrayList<>(List.of(
      new TrackInfo(1, "CS Fundamentals"),
      new TrackInfo(2, "Backend Go"),
      new TrackInfo(3, "Deeper Learning"),
      new TrackInfo(4, "Backend Typescript")
      ));

    }
    public List<CourseInfo> buildCourseInfo() {
      var tracks = buildTrackInfo();
      return new ArrayList<>(List.of(
        new CourseInfo(1, "Learn Code Python", tracks.get(0)),
        new CourseInfo(2, "Shells and Terminals", tracks.get(0)),
        new CourseInfo(3, "Learn Git", tracks.get(0)),
        new CourseInfo(4, "Build Bookbot Python", tracks.get(0)),
        new CourseInfo(5, "Learn OOP Python", tracks.get(0)),
        new CourseInfo(6, "Build Asteroids", tracks.get(0)),
        new CourseInfo(7, "Learn FP Python", tracks.get(0)),
        new CourseInfo(8, "Build SSG", tracks.get(0)),
        new CourseInfo(9, "Learn Algorithms", tracks.get(0)),
        new CourseInfo(10, "Learn Data Structures", tracks.get(0)),
        new CourseInfo(11, "Build Maze Solver", tracks.get(0)),
        new CourseInfo(12, "Learn Memory Management C", tracks.get(0)),
        new CourseInfo(13, "Personal Project", tracks.get(0)),
        new CourseInfo(14, "Learn Go", tracks.get(1)),
        new CourseInfo(15, "Learn HTTP Clients Go", tracks.get(1)),
        new CourseInfo(16, "Build Pokedex Go", tracks.get(1)),
        new CourseInfo(17, "Learn SQL", tracks.get(1)),
        new CourseInfo(18, "Build Blog Aggregator Go", tracks.get(1)),
        new CourseInfo(19, "Learn HTTP Servers Go", tracks.get(1)),
        new CourseInfo(20, "Learn File Storage S3 Go", tracks.get(1)),
        new CourseInfo(21, "Learn Docker", tracks.get(1)),
        new CourseInfo(22, "Learn Ci-Cd Go", tracks.get(1)),
        new CourseInfo(23, "Build Capstone", tracks.get(1)),
        new CourseInfo(24, "Learn Job Search", tracks.get(1)),
        new CourseInfo(25, "Learn Git 2", tracks.get(2)),
        new CourseInfo(26, "Learn Kubernetes", tracks.get(2)),
        new CourseInfo(27, "Learn Pub-Sub", tracks.get(2)),
        new CourseInfo(28, "Learn Cryptography", tracks.get(2)),
        new CourseInfo(29, "Learn Advanced Algorithms", tracks.get(2)),
        new CourseInfo(30, "Build Web Crawler Go", tracks.get(2)),
        new CourseInfo(31, "Build Web Crawler JS", tracks.get(2)),
        new CourseInfo(32, "Learn Javascript", tracks.get(2)),
        new CourseInfo(33, "Learn HTTP Clients TS", tracks.get(2)),
        new CourseInfo(34, "Build Pokedex TS", tracks.get(2)),
        new CourseInfo(35, "Build Blog Aggregator TS", tracks.get(2)),
        new CourseInfo(36, "Learn HTTP Servers TS", tracks.get(2)),
        new CourseInfo(37, "Learn Ci-Cd TS", tracks.get(2))
      ));
    }
    public int buildInfoSlug(String courseSlug) {
      return switch (courseSlug) {
        case "learn-code-python" -> 1;
        case "learn-shells-and-terminals" -> 2;
        case "learn-git" -> 3;
        case "build-bookbot-python" -> 4;
        case "learn-object-oriented-programming-python" -> 5;
        case "build-asteroids-python" -> 6;
        case "learn-functional-programming-python" -> 7;
        case "build-static-site-generator-python" -> 8;
        case "learn-algorithms-python" -> 9;
        case "learn-data-structures-python" -> 10;
        case "build-maze-solver-python" -> 11;
        case "learn-memory-management-c" -> 12;
        case "build-personal-project-1" -> 13;
        case "build-personal-project-2" -> 13;
        case "learn-golang" -> 14;
        case "learn-http-clients-golang" -> 15;
        case "build-pokedex-cli-golang" -> 16;
        case "learn-sql" -> 17;
        case "build-blog-aggregator-golang" -> 18;
        case "learn-http-servers-golang" -> 19;
        case "learn-file-storage-s3-golang" -> 20;
        case "learn-docker" -> 21;
        case "learn-ci-cd-github-docker-golang" -> 22;
        case "build-capstone-project" -> 23;
        case "learn-job-search" -> 24;
        case "learn-git-2" -> 25;
        case "learn-kubernetes" -> 26;
        case "learn-pub-sub-rabbitmq" -> 27;
        case "learn-cryptography-golang" -> 28;
        case "learn-algorithms-2-python" -> 29;
        case "build-web-crawler-golang" -> 30;
        case "build-web-crawler-javascript" -> 31;
        case "learn-javascript" -> 32;
        case "learn-http-clients-typescript" -> 33;
        case "build-pokedex-cli-typescript" -> 34;
        case "build-blog-aggregator-typescript" -> 35;
        case "learn-http-servers-typescript" -> 36;
        case "learn-ci-cd-github-docker-typescript" -> 37;

        default ->  1000;
    };
  }




}
