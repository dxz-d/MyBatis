package com.kuang.mapper;

import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUntils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/***
 * @description Teacher的Mapper层测试类
 * @author diaoxiuze
 * @date 2020/11/18 15:41
 * @param
 * @return
 */
public class TeacherMapperTest {

    Logger logger = Logger.getLogger(String.valueOf(TeacherMapperTest.class));

    @Test
    public void getTeacher() {
        final SqlSession sqlSession = MybatisUntils.getSession();
        final TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        final Teacher teacher = teacherMapper.getTeacher(1);
        System.out.println(teacher);

        sqlSession.close();
    }
}