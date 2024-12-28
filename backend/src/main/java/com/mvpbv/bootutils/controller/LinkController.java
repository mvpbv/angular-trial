package com.mvpbv.bootutils.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvpbv.bootutils.models.analytics.Urls;
import com.mvpbv.bootutils.repositories.UrlsRepository;

@RestController
@RequestMapping("/api/v1/link")
public class LinkController {
    
    @Autowired
    private UrlsRepository urlsRepository;

    @GetMapping("/getLinks") 
    public List<String> getLinks() {
        var urls = urlsRepository.findAll();
        return urls.stream().map(Urls::getUrl).toList();
    }
}
