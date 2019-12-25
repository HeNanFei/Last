package com.zjt.service.impl;

import com.zjt.mapper.ExamMapper;
import com.zjt.pojo.Exam;
import com.zjt.pojo.ExamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void update(Exam exam) {

    }

    @Override
    public void delete(Exam exam) {
        examMapper.deleteByPrimaryKey(exam.getTid());
    }
}
