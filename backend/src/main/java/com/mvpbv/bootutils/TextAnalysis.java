package com.mvpbv.bootutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

public class TextAnalysis {
    
    public static void ProcessDir() throws IOException {
        String path = "assets";
        var wordCounts = new HashMap<String, Integer>();
        
        File dir = new File(path);
        if (!dir.isDirectory() || !dir.exists()) {
            System.out.println("Not a directory");
            return;
        }
        File[] files = dir.listFiles();
        
        if (files == null) {
            System.out.println("No files found");
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
            String text = new String(Files.readAllBytes(file.toPath()));
            extractUrls(text, file.getName());
            var sections = text.split("##");
            for (var section : sections) {
                var blocks = section.split("```");
                var i = 0;
                for (var block : blocks) {
                    try (FileWriter writer = new FileWriter("processed/" + file.getName() + i + ".txt")) {
                        writer.write(block);
                    } catch (IOException e) {
                        System.err.println("An error occurred while saving cleaned text: " + e.getMessage());
                    }
                    i++;
                }
            }
            wordCounts = getWordCount(text, wordCounts);
            }
        }

        // Sort the word counts by most common
        wordCounts = wordCounts.entrySet()
            .stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(HashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), HashMap::putAll);
        saveCounts(wordCounts);
        
    }
    public static void extractUrls(String text,String fileName) {
        var urlPattern = "https?://\\S+";
        var matcher = java.util.regex.Pattern.compile(urlPattern).matcher(text);
        var urls = new java.util.ArrayList<String>();
        while (matcher.find()) {
            urls.add(matcher.group());
        }
        try (FileWriter writer = new FileWriter("asset_urls/" + fileName)) {

            for (String url : urls) {
            writer.write(url + "\n");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while saving URLs: " + e.getMessage());
        }
    }
    public static String cleanCode(String text) {
        int start = text.indexOf("```");
        while (start != -1) {
            int end = text.indexOf("```", start + 3);
            if (end == -1) {
            break;
            }
            text = text.substring(0, start) + text.substring(end + 3);
            start = text.indexOf("```");
        }
        return text;
    }
    public static void saveCounts(HashMap<String, Integer> wordCount) {
        try( FileWriter writer = new FileWriter("wordCounts.txt")) {
            for (var entry : wordCount.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while saving word counts: " + e.getMessage());
        }
    }
    public static String textFilter(String text) {
        text = text.replaceAll("[_.-]", " ");
        text = text.replaceAll("[:=,#<$;`@~%*()>/!)?]", "");
        text = text.replaceAll("[0-9]", "");
        text = text.replaceAll("[\\[\\]{}]", "");
        text = text.replaceAll("https", " ");
        text = text.replaceAll("\"", "");
        return text;
    }
    @SuppressWarnings("Convert2Diamond")
    public static HashMap<String, Integer> getWordCount(String text, HashMap<String, Integer> wordCount) {
        /*
        text = text.replaceAll("https?://\\S+\\s?", "");
        text = text.replaceAll("```.*?```", "");
        text = text.replaceAll("\\b[a-z]+(_[a-z]+)+\\b", "");
        text = text.replaceAll("\\b[a-z]+([A-Z][a-z]*)+\\b", "");
        */
        /*
        text = text.replaceAll("decaying", " decay ");
        text = text.replaceAll(" decayed ", " decay ");
        text = text.replaceAll("decays", " decay ");
        text = text.replaceAll("wikipedia"," encyclopaedia ");
        text = text.replaceAll("mathematics"," math ");
        text = text.replaceAll("mathematical"," math ");
        text = text.replaceAll("maths"," math ");



        text = text.replaceAll("http", " web ");
        text = text.replaceAll("https", " link ");
        text = text.replaceAll("alloc", " memory ");
        */
        /*
        text = text.replaceAll("[:=,#<$;`@~%*()>/!)?]", "");
        text = text.replaceAll("[0-9]", "");
        text = text.replaceAll("[\\[\\]{}]", "");
        text = text.replaceAll("\"", "");
        */
        var words = text.split("\\s+");
        for (String word : words) {
            if (word.length() < 3) {
                continue;
            }
            word = word.toLowerCase();
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }
}
