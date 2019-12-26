package com.zjt.mapper;

import com.zjt.pojo.Exam;
import com.zjt.pojo.ExamExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamMapper {
    int countByExample(ExamExample example);

    int deleteByExample(ExamExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Exam record);

    int insertSelective(Exam record);

    List<Exam> selectByExample(ExamExample example);

    Exam selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByExample(@Param("record") Exam record, @Param("example") ExamExample example);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);

    List<Exam> selectAll();


}