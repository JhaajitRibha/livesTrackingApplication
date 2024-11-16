package com.samar.technology.LivesTracker;

import com.samar.technology.LivesTracker.reactiveProgramming.service.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Map;

@SpringBootTest
public class FluxTests {

    @Autowired
    FluxLearnService fluxLearnService;

    @Test
    void info(){
        System.out.println("flux testing");
    }

    @Test
    void fluxString(){
        Flux<String> fluxString = fluxLearnService.getFlux();
        fluxString.subscribe(data->{
            System.out.println(data);
            System.out.println("done with data fluxing");

        });

    }

    @Test
    void fluxStringFromIterable(){
        Flux<String> fluxStringFromIterable = fluxLearnService.getFluxFromIterable();
        fluxStringFromIterable.subscribe(data->{
            System.out.println(data);
            System.out.println("data from iterable list");
        });
    }

    @Test
    void fluxStringFromIterableMap(){
        Flux<Map.Entry<String,String>> fluxStringFromIterableMap = fluxLearnService.getFluxfromIterableMap();
        fluxStringFromIterableMap.subscribe(data->{
            System.out.println(data);
            System.out.println("data from map");
        });
    }

    @Test
    void emptyFlux(){
        System.out.println(fluxLearnService.getEmpty());
    }

    @Test
    void CapsString(){
        Flux<String> capsString = fluxLearnService.getStringCapsLock().log();
        System.out.println("caps-string********");
        capsString.subscribe(data->{
            System.out.println(data);
        });

        StepVerifier.create(capsString)
                .expectNext("ANKIT")
                .expectNext("AJIT")
                .expectNext("ANIKET")
                .expectNext("AMLA")
                .expectNext(("BIMLA"))
                .expectComplete()
                .verify();

//        StepVerifier.create(capsString)
//                .expectNextCount(4)
//                .verifyComplete();

    }

}
