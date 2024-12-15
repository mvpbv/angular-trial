package com.mvpbv.bootutils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UrlProcessor {
    public static List<String> getAssetUrls() {
        List<String> assetUrls = new ArrayList<>();
        File folder = new File("asset_urls");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (!file.isFile()) {
                } else {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            assetUrls.add(line);
                        }
                    } catch (IOException e) {
                        System.err.println("An error occurred while reading asset urls: " + e.getMessage());
                    }
                }
            }
        }
        assetUrls = filterAssetUrls(assetUrls);
        
        return assetUrls;
    }
    public static Map<String,Integer> getDomainCount(List<String> list) {
        var domainCount = new HashMap<String, Integer>();
        for (String url : list) {
            var domain = url.replace("https://", "");
            domain = domain.replace("www", "");
            domain = domain.split("/")[0];

            if (domainCount.containsKey(domain)) {
                domainCount.put(domain, domainCount.get(domain) + 1);
            } else {
                domainCount.put(domain, 1);
            }
        }
        return domainCount;
    }
    public static HashMap<String, HashMap<String, List<String>>> getDomainTrie(List<String> list) {
        var domainTrie = new HashMap<String, HashMap<String, List<String>>>();
        for (String url : list) {
            var domain = url.replace("https://", "");
            domain = domain.replace("www", "");
            var parts = domain.split("/");
            domain = parts[0];
            var trailing = Arrays.copyOfRange(parts, 1, parts.length);
            if (trailing.length <= 1) {
                continue;
            }
            if (domainTrie.containsKey(domain)) {
                var innerTrie = domainTrie.get(domain);
                if (innerTrie.containsKey("/"+trailing[0])) {
                    if (trailing.length == 1) {
                        continue;
                    }
                    var newTrailing = "/" +String.join("/", Arrays.copyOfRange(trailing, 1, trailing.length));
                    innerTrie.get("/"+trailing[0]).add(newTrailing);
                } else {
                    if (trailing.length == 1) {
                        continue;
                    }
                    var trailingList = new ArrayList<String>();
                    var newTrailing = "/" + String.join("/", Arrays.copyOfRange(trailing, 1, trailing.length));
                    trailingList.add(newTrailing);
                    innerTrie.put("/"+trailing[0], trailingList);
                }
            } else {
                if (trailing.length == 1) {
                    continue;
                }
                var tempMap = new HashMap<String, List<String>>();
                var newTrailing = "/" + String.join("/", Arrays.copyOfRange(trailing, 1, trailing.length));
                var trailingList = new ArrayList<String>();
                trailingList.add(newTrailing);
                tempMap.put("/"+trailing[0], trailingList);
                domainTrie.put(domain, tempMap);
            }
        }
        return domainTrie;
    }

    public static List<String> filterAssetUrls(List<String> assetUrls) {
        List<String> filteredUrls = new ArrayList<>();
        for (String url : assetUrls) {
            if (url.contains("storage.googleapis.com")) {
                continue;
            }
            if (url.contains("localhost")) {
                continue;
            }
            filteredUrls.add(url);
        }
        return filteredUrls;
    }
    
}

