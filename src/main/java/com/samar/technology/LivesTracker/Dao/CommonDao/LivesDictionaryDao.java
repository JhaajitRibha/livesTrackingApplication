package com.samar.technology.LivesTracker.Dao.CommonDao;

import com.samar.technology.LivesTracker.model.LivesDictionary;
import com.samar.technology.LivesTracker.service.LivesDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


public interface LivesDictionaryDao {

    public String insertDictionary(LivesDictionary livesDictionary);

    public LivesDictionary getWordMeaningXml(Long id);
}
