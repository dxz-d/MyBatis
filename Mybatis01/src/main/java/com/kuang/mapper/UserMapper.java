package com.kuang.mapper;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/***
 * @description
 * @author diaoxiuze
 * @date 2020/11/16 13:47
 * @param
 * @return
 */
public interface UserMapper {

    /**
     * 查询全部用户
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User selectUserById(int id);

    /**
     * 通过密码和名字查询用户
     * 思路一：直接在方法中传递参数
     *
     * @param name
     * @param pwd
     * @return
     */
    User selectUserByNameAndPassword(@Param("name") String name, @Param("pwd") String pwd);

    /**
     * 通过密码和名字查询用户
     * 思路二：使用万能的map
     *
     * @param map
     * @return
     */
    User selectUserByNameAndPasswordMap(Map<String, Object> map);

    /**
     * 给数据库增加一个用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    int deleteUser(int id);
}
