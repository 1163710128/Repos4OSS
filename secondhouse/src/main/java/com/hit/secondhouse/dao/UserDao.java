package com.hit.secondhouse.dao;

import com.hit.secondhouse.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findUserById(@Param("id") int id);

    @Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(@Param("name") String name);

    @Insert("Insert INTO user(id,name,password) VALUES(#{id},#{name},#{password})")
    int insertUser(@Param("id") int id , @Param("name") String name,@Param("password") String password);

    @Delete("DELECT FROM user WHERE id = #{id}")
    int deleteUserById(@Param("id") int id);

    @Delete("DELECT FROM user WHERE name = #{name}")
    int deleteUserByName(@Param("name") String name);

    @Update("UPDATE user SET password = #{password} WHERE name = #{name}")
    void setPasswordByname(@Param("name") String name,@Param("password") String password);
}
