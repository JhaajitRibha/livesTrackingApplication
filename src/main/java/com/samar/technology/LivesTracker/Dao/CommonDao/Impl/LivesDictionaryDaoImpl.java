package com.samar.technology.LivesTracker.Dao.CommonDao.Impl;

import com.samar.technology.LivesTracker.Dao.CommonDao.LivesDictionaryDao;
import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LivesDictionaryDaoImpl implements LivesDictionaryDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public String insertDictionary(LivesDictionary livesDictionary) {
        String sql = "INSERT INTO \"lives-dictionary\" (\"word\", \"word-meaning\", \"author\") VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, livesDictionary.getWord(), livesDictionary.getWordMeaning(), livesDictionary.getAuthor());
        return livesDictionary.getWord()+" entered successfully .. !!";
    }
}
