package com.samar.technology.LivesTracker.reactiveProgramming.service.implementation;

import com.samar.technology.LivesTracker.Dao.CommonDao.LivesDictionaryDao;
import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.reactiveProgramming.DAO.ReactiveDictionaryDao;
import com.samar.technology.LivesTracker.reactiveProgramming.service.DictReactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DictReactorServiceImpl implements DictReactorService {

    @Autowired
    private ReactiveDictionaryDao reactiveDictionaryDao;
    @Override
    public Mono<LivesDictionary> create(LivesDictionary livesDictionary) {
        return reactiveDictionaryDao.createDict(livesDictionary);
    }

    @Override
    public Flux<LivesDictionary> getAllWords() {
        return null;
    }

    @Override
    public Mono<LivesDictionary> getById() {
        return null;
    }

    @Override
    public Mono<LivesDictionary> updateById(Long id) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return null;
    }
}
