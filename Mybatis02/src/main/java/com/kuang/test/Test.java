package com.kuang.test;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MyBatisUntils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    public static void main(String[] args) {

        // 第一步：获得SqlSessionFactory对象
        SqlSession sqlSession = MyBatisUntils.getSession();

        // 方式一：getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList1();

        // 方式二：古老
        // List<User> userList = sqlSession.selectList("com.kuang.mapper.UserMapper.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }

        // 关闭SqlSession
        sqlSession.close();
    }


}
