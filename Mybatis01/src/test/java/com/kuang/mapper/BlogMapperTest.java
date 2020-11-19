package com.kuang.mapper;

import com.kuang.pojo.Blog;
import com.kuang.utils.IdUntil;
import com.kuang.utils.MybatisUntil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

/***
 * @description 博客持久层测试类
 * @author diaoxiuze
 * @date 2020/11/19 14:19
 * @param
 * @return
 */
public class BlogMapperTest {

    @Test
    public void addBlog() {
        final SqlSession sqlSession = MybatisUntil.getSession();
        final BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        final Blog blog = new Blog();
        blog.setId(IdUntil.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(999);
        blogMapper.addBlog(blog);

        blog.setId(IdUntil.getId());
        blog.setTitle("Java如此简单");
        blog.getCreateTime(new Date());
        blogMapper.addBlog(blog);

        blog.setId(IdUntil.getId());
        blog.setTitle("Spring如此简单");
        blog.getCreateTime(new Date());
        blogMapper.addBlog(blog);

        blog.setId(IdUntil.getId());
        blog.setTitle("微服务如此简单");
        blog.getCreateTime(new Date());
        blogMapper.addBlog(blog);
    }
}
