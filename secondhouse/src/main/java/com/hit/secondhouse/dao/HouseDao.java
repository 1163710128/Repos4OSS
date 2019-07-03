package com.hit.secondhouse.dao;

import com.hit.secondhouse.domain.House;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HouseDao {
    @Select("SELECT * FROM house WHERE id = #{id}")
    House findHouseById(@Param("id") int id);

    @Select("SELECT * FROM house WHERE location = #{location}")
    List<House> findHouseByLocation(@Param("id") String location);

    @Select("SELECT * FROM house WHERE price = #{price}")
    List<House> findHouseByPrice(@Param("price") int price);

    @Select("SELECT * FROM house")
    List<House> getAllHouse();

    @Insert("Insert INTO house(id,location,price,description,longitude,latitude) VALUES(#{id},#{location},#{price},#{description},#{longitude},#{latitude})")
    int insertHouse(@Param("id") int id,@Param("location") String location,@Param("price") int price,@Param("description") String description,@Param("longitude") String longitude,@Param("latitude") String latitude);

    @Delete("DELECT FROM house WHERE id = #{id}")
    int deleteHouseById(@Param("id") int id);

    @Update("UPDATE house SET price = #{price} WHERE id = #{id}")
    void setPriceById(@Param("id") int id,@Param("price") int price);






}
