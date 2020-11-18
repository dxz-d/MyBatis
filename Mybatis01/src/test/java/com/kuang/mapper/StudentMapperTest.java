package com.kuang.mapper;

import com.kuang.pojo.Student;
import com.kuang.utils.MybatisUntils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/***
 * @description Student的Mapper测试类
 * @author diaoxiuze
 * @date 2020/11/18 16:26
 */
public class StudentMapperTest {

    @Test
    public void getStudent() {
        final SqlSession sqlSession = MybatisUntils.getSession();
        final StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        final List<Student> studentList = studentMapper.getStudent();
        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.close();
    }
}
