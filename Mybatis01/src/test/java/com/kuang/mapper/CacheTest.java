package com.kuang.mapper;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUntil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.sound.midi.Soundbank;

/***
 * @description Mybatis缓存测试
 * @author diaoxiuze
 * @date 2020/11/19 16:40
 * @param
 * @return
 */
public class CacheTest {

    static SqlSession sqlSession = MybatisUntil.getSession();
    static UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @Test
    public void queryById() {
        final User user = userMapper.queryById(1);
        System.out.println(user);

        User user1 = userMapper.queryById(1);
        System.out.println(user1);

        System.out.println(user == user1);
        sqlSession.close();
    }

    /**
     * 每个sqlSession中的缓存相对独立
     * sqlSession相同
     */
    @Test
    public void sqlSession() {
        final SqlSession sqlSession1 = MybatisUntil.getSession();
        final UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        final User user1 = userMapper1.queryById(1);
        System.out.println(user1);

        final SqlSession sqlSession2 = MybatisUntil.getSession();
        final UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        final User user2 = userMapper2.queryById(1);
        System.out.println(user2);

        System.out.println(user1 == user2);

        sqlSession1.close();
        sqlSession2.close();
    }
}
