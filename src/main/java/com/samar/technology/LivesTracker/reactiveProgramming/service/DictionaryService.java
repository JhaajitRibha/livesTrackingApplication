package com.samar.technology.LivesTracker.reactiveProgramming.service;


import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


@Service
public class DictionaryService {
    private final WebClient webclient;

    public DictionaryService(WebClient.Builder webclientBuilder) {
        this.webclient = webclientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Flux<LivesDictionary> fetchALlDict(){
        return webclient.get().uri("/apis/v1/dictionary/words")
                .retrieve()
                .bodyToFlux(LivesDictionary.class);
    }
}