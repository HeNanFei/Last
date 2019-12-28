package com.zjt.service.impl;

import com.zjt.mapper.ScoreMapper;
import com.zjt.pojo.Score;
import com.zjt.pojo.ScoreExample;
import com.zjt.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public void insertScore(Score score) {
        scoreMapper.insert(score);
    }

    @Override
    public void deleteScore(int sid) {
        scoreMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public List<Score> getAllScore() {



        return scoreMapper.selectAllSocres();
    }
}
