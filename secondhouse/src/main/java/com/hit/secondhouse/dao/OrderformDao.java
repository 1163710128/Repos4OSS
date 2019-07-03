package com.hit.secondhouse.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderformDao {

    @Insert("Insert INTO orderform(id,uid,hid,price) VALUES(#{id},#{uid},#{hid},#{price})")
    int insertUser(@Param("id") int id , @Param("uid") int uid, @Param("hid") int hid,@Param("price") int price);

}
