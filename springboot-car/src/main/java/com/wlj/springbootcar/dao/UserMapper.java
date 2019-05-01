package com.wlj.springbootcar.dao;

import com.wlj.springbootcar.bean.User;
import org.apache.ibatis.annotations.*;

/**
 * @author LB
 * @create 2019-04-21 14:19
 */
@Mapper
public interface UserMapper {

    @Select("select *from bookuser where user_name = #{username} and user_password = #{userpassword}")
    public User login(@Param("username") String username, @Param("userpassword") String userpassword);

    @Update("update bookuser set user_name=#{user_name},user_password=#{user_password} where user_id=#{user_id}")
    public int update(User user);

    @Insert("INSERT INTO bookuser(user_name,user_password,user_level_id) VALUES (#{user_name},#{user_password},1)")
    public int regist(User user);
}
