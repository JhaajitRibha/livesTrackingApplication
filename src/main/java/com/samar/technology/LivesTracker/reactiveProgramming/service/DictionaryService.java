package com.samar.technology.LivesTracker.reactiveProgramming.service;


import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


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

    public Mono<String> createDict(LivesDictionary livesDictionary){
        return webclient.post().uri("/apis/v1/dictionary/words")
                .bodyValue(livesDictionary)
                .retrieve()
                .onStatus(status->status.is4xxClientError() || status.is5xxServerError(),clientResponse -> Mono.error(new RuntimeException("external endpoint error"))).bodyToMono(String.class);
    }

    public Mono<LivesDictionary> updateDict(Long id,String word,String meaning,String author){
        return webclient.put()
                .uri(uriBuilder -> uriBuilder
                            .path("/apis/v1/dictionary/words/id/{id}")
                            .queryParam("word",word)
                            .queryParam("wordMeaning",meaning)
                            .queryParam("author",author)
                            .build(id)
                ).retrieve()
                .onStatus(status->status.is4xxClientError() || status.is5xxServerError(),clientResponse -> Mono.error(new RuntimeException("external endpoint error"))).bodyToMono(LivesDictionary.class);
    }

    public Mono<String> deleteByWord(String word) {
        return webclient.delete()
                .uri(uriBuilder -> uriBuilder
                        .path("/apis/v1/dictionary/words/{word}")
                        .build(word))
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        clientResponse -> Mono.error(new RuntimeException("external endpoint error"))).bodyToMono(Void.class)
                .then(Mono.just("deleted successfully"));

    }



}