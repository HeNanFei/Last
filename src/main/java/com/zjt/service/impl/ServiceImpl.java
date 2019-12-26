package com.zjt.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.zjt.mapper.ExamMapper;
import com.zjt.pojo.Exam;
import com.zjt.pojo.ExamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class ServiceImpl implements com.zjt.service.Service {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public List<Exam> getAll() {


        return examMapper.selectAll();
    }

    @Override
    public void add(Exam exam) {
        examMapper.insert(exam);
    }

    @Override
    public String update(Exam exam) {
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andTidEqualTo(exam.getTid());
        examMapper.updateByExampleSelective(exam,examExample);

        return "修改成功";
    }

    @Override
    public String delete(int exam) {
        examMapper.deleteByPrimaryKey(exam);

        return "删除成功";
    }

    @Override
    public Exam getSingleQuestion(int id) {
        return examMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Exam> getAllByType(String type) {
        System.out.println("service 中的type"+type);
        ExamExample examExample = new ExamExample();
        ExamExample.Criteria criteria = examExample.createCriteria();
        criteria.andTypeEqualTo(type);
        System.out.println("根据type获取的"+examMapper.selectByExample(examExample).size());
        return examMapper.selectByExample(examExample);
    }


}
