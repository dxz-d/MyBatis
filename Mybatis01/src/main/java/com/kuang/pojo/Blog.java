package com.kuang.pojo;

import lombok.Data;

import java.util.Date;

/***
 * @description 博客实体类
 * @author diaoxiuze
 * @date 2020/11/19 13:56
 */
@Data
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;

    public Date getCreateTime(Date date) {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
