package com.hit.secondhouse.domain;

import org.apache.ibatis.type.Alias;

@Alias("orderform")
public class Orderform {

    public int id;

    public int uid;

    public int hid;

    public int price;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
