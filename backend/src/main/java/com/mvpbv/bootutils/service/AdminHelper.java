package com.mvpbv.bootutils.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.mvpbv.bootutils.models.analytics.Readme;
import com.mvpbv.bootutils.models.analytics.Url;

@Component
public class AdminHelper {

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
        match = match.split("\\]\\(")[0];
        match = match.endsWith(".") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith(",") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith("!") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith(":") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith(")") ? match.substring(0, match.length() - 1) : match;
        match = match.endsWith(">") ? match.substring(0, match.length() - 1) : match;
        return match;
    }
}
