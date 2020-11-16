package com.kuang.mapper;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUntils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 测试类
 */
public class UserMapperTest {

    @Test
    public void test() {

        // 第一步：获得SqlSessionFactory对象
        SqlSession sqlSession = MybatisUntils.getSession();

        // 方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        // 方式二：古老
        // List<User> userList = sqlSession.selectList("com.kuang.mapper.UserMapper.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭SqlSession
        sqlSession.close();


    }
}
