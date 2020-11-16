package com.kuang.mapper;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/11/16 13:47
 * @param
 * @return
 */
public interface UserMapper {

    /**
     * 查询用户列表
     *
     * @return
     */
    List<User> getUserList();
}
