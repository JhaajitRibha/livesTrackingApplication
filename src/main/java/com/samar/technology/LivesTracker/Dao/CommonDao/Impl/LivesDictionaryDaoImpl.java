package com.samar.technology.LivesTracker.Dao.CommonDao.Impl;

import com.samar.technology.LivesTracker.Dao.CommonDao.LivesDictionaryDao;
import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.service.LivesDictionaryService;
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

    @Override
    public LivesDictionary getDictById(Long id) {
        String sql = "SELECT * FROM \"lives-dictionary\" WHERE \"lives-id\"=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},(ResultSet rs,int rowNum)->{
            LivesDictionary livesDictionary = new LivesDictionary();
            livesDictionary.setId(rs.getLong("lives-id"));
            livesDictionary.setWord(rs.getString("word"));
            livesDictionary.setWordMeaning(rs.getString("word-meaning"));
            livesDictionary.setAuthor(rs.getString("author"));
            return livesDictionary;
        });
    }

    @Override
    public LivesDictionary getDictByWordAndAuthor(String word, String author) {
        String sql = "SELECT * FROM \"lives-dictionary\" WHERE word=? and author=?";
        return jdbcTemplate.queryForObject(sql,new Object[]{word,author},(ResultSet rs,int rowNum)->{
            LivesDictionary livesDictionary = new LivesDictionary();
            livesDictionary.setId(rs.getLong("lives-id"));
            livesDictionary.setWord(rs.getString("word"));
            livesDictionary.setWordMeaning(rs.getString("word-meaning"));
            livesDictionary.setAuthor(rs.getString("author"));
            return livesDictionary;

        });
    }

    @Override
    public void deleteByWord(String word) {
        String sql = "DELETE FROM \"lives-dictionary\" WHERE \"word\" = ?";
        jdbcTemplate.update(sql,word);
    }

    @Override
    public LivesDictionary updateDictById(Long id, String word, String wordMeaning, String author) {
        LivesDictionary fetchedLivesDictionary = this.getDictById(id);
        if(fetchedLivesDictionary!=null){
            String sql = "update \"lives-dictionary\" set word=?,\"word-meaning\"=?,author=? where \"lives-id\"=?";
            jdbcTemplate.update(sql,word,wordMeaning,author,id);
            return this.getDictById(id);
        }else{
            return null;
        }
    }


}
