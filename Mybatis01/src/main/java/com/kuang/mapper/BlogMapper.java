package com.kuang.mapper;

import com.kuang.pojo.Blog;

/***
 * @description 博客的持久层
 * @author diaoxiuze
 * @date 2020/11/19 13:59
 */
public interface BlogMapper {

    /**
     * 新增一个博客
     *
     * @param blog
     * @return
     */
    int addBlog(Blog blog);
}
