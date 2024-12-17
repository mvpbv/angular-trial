package com.mvpbv.bootutils.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    
    private final WebClient webClient;

    public ClientController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    @GetMapping("/getAllLessons") 
    public Mono<JsonNode> getAllLessons() {
        return webClient.get().uri("/api/v1/getLessonData").retrieve().bodyToMono(JsonNode.class);
    }
}
