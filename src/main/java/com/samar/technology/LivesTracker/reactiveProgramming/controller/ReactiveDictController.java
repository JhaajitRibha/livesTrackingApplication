package com.samar.technology.LivesTracker.reactiveProgramming.controller;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.reactiveProgramming.service.DictReactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/apis/v1/dict/reactive")
public class ReactiveDictController {

    @Autowired
    DictReactorService dictReactorService;

    @PostMapping("/create")
    public Mono<LivesDictionary> createDict(@RequestBody LivesDictionary livesDictionary){
        return dictReactorService.create(livesDictionary);
    }

}
