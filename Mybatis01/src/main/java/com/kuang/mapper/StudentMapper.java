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
     *
     * @return
     */
    List<Student> getStudent();
}
