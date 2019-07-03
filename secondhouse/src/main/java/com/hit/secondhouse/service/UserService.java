package com.hit.secondhouse.service;


import com.hit.secondhouse.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hit.secondhouse.domain.User;

@Service
public class UserService {

    @Autowired
    public UserDao userDao;

    public User selectService(String name){
        return userDao.findUserByName(name);
    }

    public User selectService(int id){
        return userDao.findUserById(id);
    }


    @Transactional
    public void insertService(int id,String name,String password){
        userDao.insertUser(id, name, password);
    }

    @Transactional
    public void setPasswordByNameService(String name , String password){
        userDao.setPasswordByname(name,password);
    }

    @Transactional
    public void deleteUserById(int id){
        userDao.deleteUserById(id);
    }


}
