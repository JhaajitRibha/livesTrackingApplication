package com.samar.technology.LivesTracker.reactiveProgramming.service;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface DictReactorService {

    public Mono<LivesDictionary> create(LivesDictionary livesDictionary);
    public Flux<LivesDictionary> getAllWords();

    public Mono<LivesDictionary> getById();

    public Mono<LivesDictionary> updateById(Long id);

    public Mono<Void> deleteById(Long id);

}
