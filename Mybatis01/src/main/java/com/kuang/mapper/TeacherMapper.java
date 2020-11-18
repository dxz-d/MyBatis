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

    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacher(@Param("tid") Integer id);
}
