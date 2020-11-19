package com.kuang.mapper;

import com.kuang.pojo.Student;

import java.util.List;

/***
 * @description Student的Mapper层
 * @author diaoxiuze
 * @date 2020/11/18 16:23
 * @param
 * @return
 */
public interface StudentMapper {

    /**
     * 查询所有的学生信息，以及对应的老师信息
     * 1.按照查询进行嵌套处理就像sql的子查询
     *
     * @return
     */
    List<Student> getStudent();

    /**
     * 查询所有的学生信息，以及对应的老师信息
     * 2.按照结果进行嵌套处理就像sql表中的关联查询
     *
     * @return
     */
    List<Student> getStudent01();
}
