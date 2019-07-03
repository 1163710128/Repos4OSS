package com.hit.secondhouse.service;


import com.hit.secondhouse.dao.UserRecDao;
import com.hit.secondhouse.domain.UserRec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRecService {

    @Autowired
    public UserRecDao userRecDao;

    public List<Integer> getRecordService(int id){
        List<Integer> list = new ArrayList<>();
        String rec = userRecDao.findUserRecById(id);
        String[] str = rec.split(" \\+");
        for(int i = 0;i < str.length;i++){
            list.add(Integer.valueOf(str[i]));
        }
        return list;
    }
}
