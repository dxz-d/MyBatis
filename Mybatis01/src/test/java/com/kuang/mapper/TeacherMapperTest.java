package com.kuang.mapper;

import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUntil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/***
 * @description Teacher的Mapper层测试类
 * @author diaoxiuze
 * @date 2020/11/18 15:41
 * @param
 * @return
 */
public class TeacherMapperTest {

    @Test
    public void getTeacherAnnotation() {
        final SqlSession sqlSession = MybatisUntil.getSession();
        final TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        final Teacher teacher = teacherMapper.getTeacherAnnotation(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void getTeacher() {
        final SqlSession sqlSession = MybatisUntil.getSession();
        final TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        final Teacher teacher = teacherMapper.getTeacher(1);
        System.out.println("老师的名字：" + teacher.getName() + ",学生的名字：" + teacher.getStudentList());

        sqlSession.close();
    }

    @Test
    public void getTeacher01() {
        final SqlSession sqlSession = MybatisUntil.getSession();
        final TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        final Teacher teacher = teacherMapper.getTeacher01(1);
        System.out.println("老师的名字：" + teacher.getName() + ",学生的名字：" + teacher.getStudentList());

        sqlSession.close();
    }
}
