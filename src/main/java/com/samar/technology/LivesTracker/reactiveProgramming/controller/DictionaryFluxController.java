package com.samar.technology.LivesTracker.reactiveProgramming.controller;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.reactiveProgramming.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/flux/dict")
public class DictionaryFluxController {

    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryFluxController(DictionaryService dictionaryService){
        this.dictionaryService=dictionaryService;
    }

    @GetMapping(produces = "application/xml")
    public Flux<LivesDictionary> fetchAllDict(){
          return dictionaryService.fetchALlDict();
    }

    @PostMapping
    public Mono<String> createDict(@RequestBody LivesDictionary livesDictionary){
        return dictionaryService.createDict(livesDictionary);
    }

    @PutMapping("/{id}")
    public Mono<LivesDictionary> updateDict(@PathVariable Long id,
                                   @RequestParam String word,
                                   @RequestParam String wordMeaning,
                                   @RequestParam String author){
        return dictionaryService.updateDict(id,word,wordMeaning,author);
    }

    @DeleteMapping("/{word}")
    public Mono<String> deleteDict(@PathVariable String word){
        return dictionaryService.deleteByWord(word);
    }

}
