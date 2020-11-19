package com.kuang.mapper;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/***
 * @description Teacher Mapper层
 * @author diaoxiuze
 * @date 2020/11/18 15:36
 */
public interface TeacherMapper {

    /**
     * 获取老师
     *
     * @param id
     * @return
     */
    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacherAnnotation(@Param("tid") Integer id);

    /**
     * 获取老师指定老师，及老师下的所有学生
     * 按结果查询嵌套
     *
     * @param id
     * @return
     */
    Teacher getTeacher(int id);

    /**
     * 按查询嵌套处理
     *
     * @param id
     * @return
     */
    Teacher getTeacher01(int id);

}
