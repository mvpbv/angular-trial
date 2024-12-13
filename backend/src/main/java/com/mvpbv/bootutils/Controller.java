package com.mvpbv.bootutils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final ApiService apiService;

    public Controller(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/healthz")
    public String hello() {
        return "Ready to go!";
    }
    @RequestMapping("err") 
    public String err() {
        return "Error!";
    }
    @GetMapping("/get")
    public Mono<String> get() {
        return apiService.get();
    }
}

