package com.zjt.web;

import com.zjt.pojo.Answer;
import com.zjt.pojo.Exam;
import com.zjt.service.Service;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private Service service;

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    /**
     * getAll
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/question/findall")
    public List<Exam> getAll() {

        System.out.println("it has been findAll");
        return service.getAll();
    }

    /**
     * add
     */
    @RequestMapping("/question/add")
    public void add(Exam exam) {

        service.add(exam);


    }

    /**
     * update
     */
    @RequestMapping("/question/update")
    public void update() {


    }

        /**
         * delete
         */
       @RequestMapping("/question/delete")
        public void delete(){

       }

    /**
     * get answer from students
     * @return
     */
    @RequestMapping("/question/getquestions")
        public String getquestions(Answer answer){
        int total = 0;
        int all = 0;
        System.out.println("the answer you get"+answer);
            String page = null;
        List<Exam> allQuestion = service.getAll();
        for (int i=0;i<allQuestion.size();i++){
            String result = answer.getAnswerByNumber(i);
            System.out.println("前台传来的答案"+result+"索引为"+i);
            if (allQuestion.get(i).getAnswer().equals(answer.getAnswerByNumber(i))){
                total = allQuestion.get(i).getScore();
                all += total;

            }
        }
        System.out.println("总分哦亲爱的"+all);

        return "info";
       }

}