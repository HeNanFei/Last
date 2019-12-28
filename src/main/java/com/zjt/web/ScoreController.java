package com.zjt.web;

import com.zjt.pojo.Score;
import com.zjt.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @RequestMapping("/score/delete")
    public void delete(Integer sid){
        scoreService.deleteScore(sid);
    }
    @ResponseBody
    @RequestMapping("/score/findall")
    public List<Score> findall(){

        return scoreService.getAllScore();
    }
}
