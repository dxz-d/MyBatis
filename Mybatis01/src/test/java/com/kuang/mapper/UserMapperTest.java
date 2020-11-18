package com.kuang.mapper;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUntils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 */
public class UserMapperTest {

    static Logger logger = Logger.getLogger(String.valueOf(UserMapperTest.class));

    @Test
    public void rowBounds() {

        final SqlSession sqlSession = MybatisUntils.getSession();
        // 第二页
        int currentPage = 0;
        // 每页显示几个
        int pageSize = 4;
        final RowBounds rowBounds = new RowBounds((currentPage - 1) * pageSize, pageSize);
        final List<User> userList = sqlSession.selectList("com.kuang.mapper.UserMapper.getUserRowBounds", null, rowBounds);

        System.out.println(userList);

        sqlSession.close();

    }

    @Test
    public void limitSelectUser() {
        final SqlSession sqlSession = MybatisUntils.getSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("startIndex", 0);
        hashMap.put("pageSize", 3);
        final List<User> userList = userMapper.selectUser(hashMap);

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void log4j() {
        logger.info("进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
    }

    // 1.查询用户
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


    // 通过密码和名字查询用户(方式一：通过参数传递)
    @Test
    public void selectUserByNameAndPassword() {
        final SqlSession sqlSession = MybatisUntils.getSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final User user = userMapper.selectUserByNameAndPassword("张三", "abcdef");

        System.out.println(user);

        sqlSession.close();
    }

    // 通过密码和名字查询用户(方式二：Map传值)
    @Test
    public void selectUserByNameAndPasswordMap() {
        final SqlSession sqlSession = MybatisUntils.getSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "狂神");
        map.put("pwd", "123456");
        final User user = userMapper.selectUserByNameAndPasswordMap(map);

        System.out.println(user);

        sqlSession.close();
    }

    // 给数据库增加一个用户
    @Test
    public void addUser() {
        final SqlSession sqlSession = MybatisUntils.getSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final User user = new User(4, "张聪辉", "666");
        final int i = userMapper.addUser(user);

        System.out.println("给数据库增加一个用户:" + i);

        // 提交事务，重点！不写的话不会提交到数据库
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUserMap() {
        final SqlSession sqlSession = MybatisUntils.getSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 5);
        map.put("username", "刁秀泽");

        final int i = userMapper.addUserMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    // 模糊查询用户信息
    @Test
    public void selectUserLike() {
        final SqlSession sqlSession = MybatisUntils.getSession();
        final UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // final List<User> userList = userMapper.selectUserLike("%刁%");

        final List<User> userList = userMapper.selectUserLike("秀");
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
