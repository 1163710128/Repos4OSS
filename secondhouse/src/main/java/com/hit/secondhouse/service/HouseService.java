package com.hit.secondhouse.service;

import com.hit.secondhouse.dao.HouseDao;
import com.hit.secondhouse.dao.OrderformDao;
import com.hit.secondhouse.domain.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HouseService {

    @Autowired
    public HouseDao houseDao;

    @Autowired
    public OrderformDao orderformDao;

    public House findHouseByIdService(int id){
        return houseDao.findHouseById(id);
    }

    public List<House> findHouseByLocation(String location){
        return houseDao.findHouseByLocation(location);
    }

    public List<House> findHouseByPrice(int price){
        return houseDao.findHouseByPrice(price);
    }

    public List<House> getAllHouse(){return  houseDao.getAllHouse();}

    @Transactional
    public void insertHouseService(int id,String location,int price,String description,String longitude,String latitude){
        houseDao.insertHouse(id,location,price,description,longitude,latitude);
    }

    @Transactional
    public void setPriceByIdService(int id,int price){
        houseDao.setPriceById(id,price);
    }

    @Transactional
    public void deleteHouseById(int id){
        houseDao.deleteHouseById(id);
    }

    public void addOrderService(int id, int uid,int hid,int price){
        orderformDao.insertUser(id,uid,hid,price);
    }


}
