package com.mvpbv.bootutils.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvpbv.bootutils.models.links.Domain;
import com.mvpbv.bootutils.models.links.Url;
import com.mvpbv.bootutils.service.LinkService;

@RestController
@RequestMapping("/api/v1/link")
public class LinkController {
    
    @Autowired
    private LinkService linkService;


    @GetMapping("/getLinks") 
    public List<Url> getLinks(@RequestParam(required = false) Integer domainId) {
        return linkService.findLinks(domainId); 
    }
    @GetMapping("/domains")
    public List<Domain> getDomains(@RequestParam(required = false) boolean sort) {
        return linkService.findDomains(); 
    }
}
