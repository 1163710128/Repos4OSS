package com.hit.secondhouse.domain;

import org.apache.ibatis.type.Alias;

@Alias("administrator")
public class Administrator {
    private int adminId;
    private String adminLevel;
    private int employeeId;

    private Administrator(int adminId,String adminLevel, int employeeId){
        this.adminId = adminId;
        this.adminLevel = adminLevel;
        this.employeeId = employeeId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
