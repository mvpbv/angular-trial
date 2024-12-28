package com.mvpbv.bootutils.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvpbv.bootutils.models.analytics.Domain;
import com.mvpbv.bootutils.models.analytics.Url;
import com.mvpbv.bootutils.repositories.DomainRepository;
import com.mvpbv.bootutils.repositories.UrlsRepository;

@RestController
@RequestMapping("/api/v1/link")
public class LinkController {
    
    @Autowired
    private UrlsRepository urlsRepository;

    @Autowired
    private DomainRepository domainRepository;

    @GetMapping("/getLinks") 
    public List<String> getLinks() {
        var urls = urlsRepository.findAll();
        return urls.stream().map(Url::getUrl).toList();
    }
    @GetMapping("/domains")
    public List<String> getDomains() {
        var domains = domainRepository.findAll();
        return domains.stream().map(Domain::getDomain).toList();
    }
}
