package com.samar.technology.LivesTracker.service;

import com.samar.technology.LivesTracker.Dao.CommonDao.LivesDictionaryDao;
import com.samar.technology.LivesTracker.mapper.LivesDictionaryRowMapper;
import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivesDictionaryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LivesDictionaryDao livesDictionaryDao;

    public List<LivesDictionary> getLivesDictionaries(){

        String sql = "SELECT * FROM \"lives-dictionary\"";
        return jdbcTemplate.query(sql,new LivesDictionaryRowMapper());
    }

    public String dictionaryInsertion(LivesDictionary livesDictionary){
        return livesDictionaryDao.insertDictionary(livesDictionary);
    }
}
