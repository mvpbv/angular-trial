package com.mvpbv.bootutils.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mvpbv.bootutils.models.analytics.AnalyticsStats;
import com.mvpbv.bootutils.models.analytics.HotSpot;
import com.mvpbv.bootutils.service.AnalyticsService;
import com.mvpbv.bootutils.service.CodeService;

@RestController
@RequestMapping("/api/v1/code")
public class CodeController {

    @Autowired
    private CodeService codeService;

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/getPrimary") 
    public Map<Integer, List<HotSpot>> getPrimary(@RequestParam int window, @RequestParam int limit) {
        return codeService.findPrimary(window, limit);
    }
    @GetMapping("/getPrimaryStats") 
    public AnalyticsStats getPrimaryStats(@RequestParam int window) {
        return analyticsService.findPrimaryStats(window);
    }
}
