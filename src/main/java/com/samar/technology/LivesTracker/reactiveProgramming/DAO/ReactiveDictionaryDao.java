package com.samar.technology.LivesTracker.reactiveProgramming.DAO;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface ReactiveDictionaryDao {
    public Mono<LivesDictionary> createDict(LivesDictionary livesDictionary);
}
