package com.samar.technology.LivesTracker.Dao.CommonDao.Impl;

import com.samar.technology.LivesTracker.Dao.CommonDao.LivesDictionaryDao;
import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;

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

    @Override
    public LivesDictionary getWordMeaningXml(Long id) {
        String sql = "SELECT * FROM \"lives-dictionary\" WHERE \"lives-id\"=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},(ResultSet rs, int rowNum)->{
              LivesDictionary dictionary = new LivesDictionary();
              dictionary.setId(rs.getLong("lives-id"));
              dictionary.setWord(rs.getString("word"));
              dictionary.setWordMeaning(rs.getString("word-meaning"));
              dictionary.setAuthor(rs.getString("author"));
              return dictionary;
        });
    }
}
