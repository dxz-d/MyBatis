package com.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/***
 * @description sqlSessionFactory --> sqlSession
 * @author diaoxiuze
 * @date 2020/11/16 11:13
 */
public class MybatisUntil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 使用mybatis第一步：获取sqlSession对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 既然有了SqlSessionFactory,顾名思义，我们就可以从中获取SqlSessionFactory的实例
    // SqlSession完全包含了面向数据库执行sql命令所需的所有方法
    // 获取sqlSession连接
    public static SqlSession getSession() {
        // 设置提交事务
        return sqlSessionFactory.openSession(true);
    }


}