package com.samar.technology.LivesTracker.mapper;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LivesDictionaryRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        LivesDictionary livesDictionary = new LivesDictionary();
        livesDictionary.setId(rs.getLong("lives-id"));
        livesDictionary.setWord(rs.getString("word"));
        livesDictionary.setAuthor(rs.getString("author"));
        livesDictionary.setWordMeaning(rs.getString("word-meaning"));
        return livesDictionary;
    }
}
