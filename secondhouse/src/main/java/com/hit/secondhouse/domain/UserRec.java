package com.hit.secondhouse.domain;


import org.apache.ibatis.type.Alias;

@Alias("userrec")
public class UserRec {
    private int id;

    private String record;

    public UserRec(int id, String record){
        this.id = id;
        this.record = record;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "UserRec{" +
                "id=" + id +
                ", record='" + record + '\'' +
                '}';
    }
}
