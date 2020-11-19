package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 * @description 老师类
 * @author diaoxiuze
 * @date 2020/11/18 15:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int id;
    private String name;

    // 一个老师对应多个学生
    private List<Student> studentList;
}
