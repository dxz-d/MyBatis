package com.kuang.mapper;

import com.kuang.pojo.Blog;
import com.kuang.utils.IdUntil;
import com.kuang.utils.MybatisUntil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/***
 * @description 博客持久层测试类
 * @author diaoxiuze
 * @date 2020/11/19 14:19
 * @param
 * @return
 */
public class BlogMapperTest {

    static SqlSession sqlSession = MybatisUntil.getSession();
    static BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

    @Test
    public void addBlog() {
        Blog blog = new Blog();
        blog.setId(IdUntil.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(999);
        blogMapper.addBlog(blog);

        blog.setId(IdUntil.getId());
        blog.setTitle("Java如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IdUntil.getId());
        blog.setTitle("Spring如此简单");
        blogMapper.addBlog(blog);

        blog.setId(IdUntil.getId());
        blog.setTitle("微服务如此简单");
        blogMapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogIf() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("title", "Java如此简单");
        hashMap.put("author", "狂神说");
        final List<Blog> blogList = blogMapper.queryBlogIf(hashMap);
        System.out.println(blogList);

        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("id", "64df8e526b794f76b2d0d74cf23ad886");
        hashMap.put("title", "动态SQL1");
        hashMap.put("author", "秦疆1");
        blogMapper.updateBlog(hashMap);

        sqlSession.close();
    }

    @Test
    public void queryBlogChoose() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("title", "动态SQL1");
        hashMap.put("author", "秦疆1");
        blogMapper.queryBlogChoose(hashMap);

        sqlSession.close();
    }
}
