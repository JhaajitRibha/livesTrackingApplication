package com.samar.technology.LivesTracker.reactiveProgramming.controller;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.reactiveProgramming.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
}
