package com.zjt.service;


import com.zjt.pojo.Exam;

import java.util.List;

public interface Service {

    public List<Exam> getAll();


    public void add(Exam exam);


    public String update(Exam exam);


    public String delete(int exam);

    public  Exam getSingleQuestion(int id);

    public List<Exam> getAllByType(String type);



}
