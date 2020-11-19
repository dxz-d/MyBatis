package com.kuang.mapper;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUntil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}
