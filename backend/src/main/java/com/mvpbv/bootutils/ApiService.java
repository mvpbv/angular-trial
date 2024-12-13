package com.mvpbv.bootutils;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;


@Service
public class ApiService {
    private final WebClient webClient;

    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.boot.dev/v1/static/lessons").build();
        
    }
    public Mono<String> get() {
        return this.webClient.get()
        .uri("/6b89a3b7-18dd-43f4-a229-db4ea1464249")
        .retrieve()
        .bodyToMono(String.class);
    }
}
