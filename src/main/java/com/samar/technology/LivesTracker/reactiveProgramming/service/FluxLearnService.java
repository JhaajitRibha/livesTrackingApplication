package com.samar.technology.LivesTracker.reactiveProgramming.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FluxLearnService {

    public Flux<String> getFlux(){
        return Flux.just("Ankit","Ajit","Aniket","amla","bimla");
    }

    public Flux<String> getFluxFromIterable(){
        List<String> listOfString = List.of("aa","agdgd","gdwg","gee");
        return Flux.fromIterable(listOfString);
    }

    public Flux<Map.Entry<String,String>> getFluxfromIterableMap(){
        Map<String,String> listOfMaps = new HashMap<>();
        listOfMaps.put("1","sm");
        listOfMaps.put("2","sss");
        return Flux.fromIterable((listOfMaps.entrySet()));
    }

    public Flux<Void> getEmpty(){
        return Flux.empty();
    }

    public Flux<String> getStringCapsLock(){
        Flux<String> capsString = getFlux().map(flux->flux.toUpperCase());
        return capsString;
    }
}
