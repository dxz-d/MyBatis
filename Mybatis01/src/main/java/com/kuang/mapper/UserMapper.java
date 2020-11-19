package com.kuang.mapper;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
     * 根据id查询用户(测试缓存)
     *
     * @param id
     * @return
     */
    User queryById(@Param("id") int id);

    /**
     * 反射查询用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> selectUserByReflect();

    /**
     * RowBounds实现分页
     *
     * @return
     */
    List<User> getUserRowBounds();

    /**
     * 分页查询
     *
     * @param map
     * @return
     */
    List<User> selectUser(Map<String, Integer> map);

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
    @Insert("insert into user values (#{id}, #{pwd}, #{name})")
    int addUser(User user);

    /**
     * 给数据库增加一个用户给数据库增加一个用户
     * map传值
     *
     * @param map
     * @return
     */
    int addUserMap(Map<String, Object> map);

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

    /**
     * 模糊查询
     *
     * @param username
     * @return
     */
    List<User> selectUserLike(String username);
}
