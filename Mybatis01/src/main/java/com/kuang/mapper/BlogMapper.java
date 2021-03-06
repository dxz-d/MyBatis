package com.kuang.mapper;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

/***
 * @description 博客的持久层
 * @author diaoxiuze
 * @date 2020/11/19 13:59
 */
public interface BlogMapper {

    /**
     * 新增一个博客
     * @param blog
     * @return
     */
    int addBlog(Blog blog);

    /**
     * 动态sql之if标签
     * @param map
     * @return
     */
    List<Blog> queryBlogIf(Map map);

    /**
     * 动态sql之set标签
     * @param map
     * @return
     */
    int updateBlog(Map map);

    /**
     * 动态sql之choose标签
     *
     * @param map
     * @return
     */
    List<Blog> queryBlogChoose(Map map);

    /**
     * 动态sql之foreach标签
     *
     * @param map
     * @return
     */
    List<Blog> queryBlogForeach(Map map);
}
