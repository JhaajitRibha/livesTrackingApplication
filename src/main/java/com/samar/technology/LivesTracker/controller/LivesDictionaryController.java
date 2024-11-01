package com.samar.technology.LivesTracker.controller;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.service.LivesDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis/v1/dictionary")
public class LivesDictionaryController {


    @Autowired
    LivesDictionaryService livesDictionaryService;

    @GetMapping("/words")
    public List<LivesDictionary> getAllDictionaries(){
        return livesDictionaryService.getLivesDictionaries();
    }

    @PostMapping("/words")
    public String dictionaryInsertion(@RequestBody LivesDictionary livesDictionary){
        return livesDictionaryService.dictionaryInsertion(livesDictionary);
    }

}
