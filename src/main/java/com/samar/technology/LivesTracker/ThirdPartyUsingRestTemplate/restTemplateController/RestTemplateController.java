package com.samar.technology.LivesTracker.ThirdPartyUsingRestTemplate.restTemplateController;

import com.samar.technology.LivesTracker.ThirdPartyUsingRestTemplate.restTemplateService.RestTemplateService;
import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/rest/template")
public class RestTemplateController {
    @Autowired
    RestTemplateService restTemplateService;

    @GetMapping("/dict/{id}")
    public LivesDictionary getDictById(@PathVariable Long id){
        return restTemplateService.getDictById(id);
    }
    @PostMapping
    public String saveDict(@RequestBody LivesDictionary livesDictionary){
        return restTemplateService.saveDict(livesDictionary);
    }
}
