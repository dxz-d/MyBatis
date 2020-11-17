package com.kuang.mapper;

import com.kuang.pojo.User;

import java.util.List;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/11/17 10:37
 */
public interface UserMapper {

    /**
     * 查询全部用户
     *
     * @return
     */
    List<User> getUserList1();
}
