package com.hit.secondhouse.dao;

import com.hit.secondhouse.domain.Administrator;
import com.hit.secondhouse.domain.House;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdministratorDao {

    @Select("Select * from admin")
    List<Administrator> getAllAdmin();

    @Select("Select * from admin Where emploeeId = #{employeeId}")
    Administrator findAdminByEid(@Param("employeeId") int employeeId);

    @Insert("Insert admin(adminId,adminLevel,employeeId) VALUES(#{adminId},#{adminLevel},#{employeeId}")
    void insertAdmin(@Param("adminId") int adminId, @Param("adminLevel") String adminLevel, @Param("employeeId") int employeeid);

    @Delete("DELECT FROM admin WHERE adminId = #{adminId}")
    void deleteAdminById(@Param("adminId") int adminId);

    @Select("Select * From house where verification = false")
    List<House> getAllUnverified();

    @Update("UPDATE house SET verification = true WHERE id = #{id}")
    void setVerifiedById(@Param("id") int id);
}
