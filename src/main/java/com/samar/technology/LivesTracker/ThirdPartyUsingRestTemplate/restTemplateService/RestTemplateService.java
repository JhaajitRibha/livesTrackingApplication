package com.samar.technology.LivesTracker.ThirdPartyUsingRestTemplate.restTemplateService;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {

    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080";

    @Autowired
    public RestTemplateService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public LivesDictionary getDictById(Long id){
       return restTemplate.getForEntity(baseUrl+"/apis/v1/dictionary/words/" + id,LivesDictionary.class).getBody();
    }

    public String saveDict(LivesDictionary livesDictionary){
        String url = baseUrl+"/apis/v1/dictionary/words";
        return restTemplate.postForObject(url,livesDictionary,String.class);

    }

    public String getPostById(Integer id){
        String url = "https://dummyjson.com/posts/"+id;
        return restTemplate.getForEntity(url,String.class).getBody();
    }
}
