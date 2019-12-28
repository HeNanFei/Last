package com.zjt.service;

import com.zjt.pojo.Score;

import java.util.List;

public interface ScoreService {

    public void insertScore(Score score);

    public void deleteScore(int sid);

    public List<Score> getAllScore();



}
