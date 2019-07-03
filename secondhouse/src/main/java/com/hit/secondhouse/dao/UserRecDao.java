package com.hit.secondhouse.dao;


import com.hit.secondhouse.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserRecDao {

    @Select("SELECT * FROM userrec WHERE userId = #{id}")
    String findUserRecById(@Param("id") int id);

}
