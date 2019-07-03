package com.hit.secondhouse.service;

import com.hit.secondhouse.dao.OrderformDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderformService {

    @Autowired
    public OrderformDao orderformDao;

    public void addOrderService(int id, int uid,int hid,int price){
        orderformDao.insertUser(id,uid,hid,price);
    }
}
