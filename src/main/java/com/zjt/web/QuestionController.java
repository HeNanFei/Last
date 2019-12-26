package com.zjt.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.zjt.pojo.Answer;
import com.zjt.pojo.Exam;
import com.zjt.pojo.JSONObject;
import com.zjt.pojo.Total;
import com.zjt.service.Service;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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
    public List<Exam> findAll() {
        System.out.println(choice+"你的选择");
        System.out.println(service.getAllByType(choice));
        System.out.println("it has been findAll");
        return service.getAllByType(choice);
    }

    /**
     * get all question without type criteria
     * @param
     */
    @ResponseBody
    @RequestMapping("/question/getall")
    public List<Exam> getall(){

        return service.getAll();
    }



    /**
     * add this method will be abandoned
     */
    @RequestMapping("/question/add")
    public void add(Exam exam) {

        service.add(exam);


    }

    @RequestMapping("/question/realadd")
    public void realadd(String strings[]){

        System.out.println(strings.length);


    }


    /**
     * update
     */
    Integer qid = null;

    @RequestMapping("/question/update")
    public String update(int id) {
        System.out.println("update 中的exam id" + id);
        qid = id;
        Exam exam = service.getSingleQuestion(id);


        return "add";

    }

    /**
     * Real update
     *
     * @param exam
     * @return
     */
    @ResponseBody
    @RequestMapping("/question/realupdate")
    public String realUpdate(Exam exam) {

        exam.setTid(qid);
        System.out.println("接收的更新数据"+exam);
        service.update(exam);


        return "修改成功";
    }

    /**
     * return the question
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/question/return")
    public Exam getExam() {

        return service.getSingleQuestion(qid);
    }


    /**
     * delete
     */
    @RequestMapping("/question/delete")
    public String delete(int id) {
        System.out.println("delete zhong de id" + id);

        return service.delete(id);
    }

    /**
     * get answer from students
     *
     * @return
     */
    @RequestMapping("/question/getquestions")
    public String getquestions(Answer answer, HttpServletRequest request) {
        int total = 0;
        int all = 0;
        System.out.println("the answer you get" + answer);
        String page = null;
        List<Exam> allQuestion = service.getAll();
        for (int i = 0; i < allQuestion.size(); i++) {
            String result = answer.getAnswerByNumber(i);
            System.out.println("前台传来的答案" + result + "索引为" + i);
            if (allQuestion.get(i).getAnswer().equals(answer.getAnswerByNumber(i))) {
                total = allQuestion.get(i).getScore();
                all += total;

            }
        }
        System.out.println("总分哦亲爱的" + all);
        request.setAttribute("score", all);
        return "infor";
    }

    @RequestMapping("/question/getformdata")
    public String getformdata(String strings,HttpServletRequest request){
        int sumSocre = 0;
        int templateScore =0;
        System.out.println(strings);
        String[] split = strings.split(",");
        System.out.println(split.length+"尺度");

        List<Exam> all = service.getAll();
        System.out.println(all.size());
        for (int i = 0;i<all.size();i++){
            if(all.get(i).getAnswer().equals(split[i])){
                templateScore = all.get(i).getScore();
                sumSocre += templateScore;
            }
        }


        System.out.println("总分realupdate" + sumSocre);
        request.setAttribute("score", sumSocre);
        return "infor";
    }
    String choice = null;
    @RequestMapping("/question/choose")
    public String choose(String type){
        choice = type;
        System.out.println("捕捉的张锦添"+choice);
        return "test";
    }

    /**
     * get total scores and titles in page test
     * @return
     */
    @ResponseBody
    @RequestMapping("/question/gettotal")
    public Total getTotal(){
        int total=0;
        int temp =0;
        List<Exam> allByType = service.getAllByType(choice);
        for (int i=0;i<allByType.size();i++){

            temp = allByType.get(i).getScore();
            total += temp;
        }
        Total total1 = new Total();
        total1.setScore(total);
        total1.setTitles(allByType.size());

        return total1;
    }


}