package com.zjt.service;


import com.zjt.pojo.Exam;

import java.util.List;

public interface Service {

    public List<Exam> getAll();


    public void add(Exam exam);


    public void update(Exam exam);


    public void delete(Exam exam);



}
