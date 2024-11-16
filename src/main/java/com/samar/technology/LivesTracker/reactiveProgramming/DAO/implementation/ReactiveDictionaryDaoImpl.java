package com.samar.technology.LivesTracker.reactiveProgramming.DAO.implementation;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.reactiveProgramming.DAO.ReactiveDictionaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ReactiveDictionaryDaoImpl implements ReactiveDictionaryDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Mono<LivesDictionary> createDict(LivesDictionary livesDictionary) {
        String sql = "INSERT INTO \"lives-dictionary\" (\"word\", \"word-meaning\", \"author\") VALUES (?, ?, ?)";
        int res = jdbcTemplate.update(sql, livesDictionary.getWord(), livesDictionary.getWordMeaning(), livesDictionary.getAuthor());
        if(res>0){
            return Mono.just(livesDictionary);
        }
        return Mono.empty();
    }
}
