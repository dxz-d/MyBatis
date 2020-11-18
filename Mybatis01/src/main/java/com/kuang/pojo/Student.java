package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * @description 学生类
 * @author diaoxiuze
 * @date 2020/11/18 15:11n
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private int id;
    private String name;
    private int tid;

    /**
     * 多对一：多个学生对一个老师
     */
    private Teacher teacher;
}
