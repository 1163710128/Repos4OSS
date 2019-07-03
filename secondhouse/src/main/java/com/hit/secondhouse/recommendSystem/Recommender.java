package com.hit.secondhouse.recommendSystem;

import com.hit.secondhouse.domain.House;
import com.hit.secondhouse.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Recommender {


    public HouseService houseService;


    /*根据单个用户的历史记录选择推进的房屋，数目为一个*/
    public House getRecommended(List<House> clickedList){
        List<Integer> idList = new ArrayList<>();
        for(int i = 0;i < clickedList.size();i++){
            idList.add(clickedList.get(i).getId());
        }

        Map<Integer,Integer> simMap = new HashMap<>();
        List<House> houseList = houseService.getAllHouse();
        for(int i = 0; i < houseList.size();i++){
            simMap.put(houseList.get(i).getId(),0);
        }


        int [][] sim = calculateSimilarity(houseList);
        for(int i = 0;i < houseList.size();i++){
            if(idList.contains(houseList.get(i).getId())){
                for(int x = 0; x < houseList.size();x++){
                    int simValue = simMap.get(x);
                    simValue += sim[i][x];
                    simMap.put(x,simValue);
                }
            }
        }

        /* 得出相似度的map之后，选取不在idList中的最大的几个*/
        int max = 0;
        for(int i = 0;i < idList.size();i++){/*去除看过的*/
            simMap.put(idList.get(i),0);
        }

        int tmpId = -1;
        for(int i = 0; i < houseList.size();i++){
            if(max < simMap.get(houseList.get(i).getId())){
                max = simMap.get(houseList.get(i).getId());
                tmpId = i;
            }
        }

        return houseList.get(tmpId);
    }



    public int[][] calculateSimilarity(List<House> houseList){//对于list需要去重
        int size = houseList.size();
        int[][] similarity = new int[size][size];
        for(int x = 0; x < size;x++){
            for(int y = 0;y < size;y++)
                if(x == y) similarity[x][y] = 30;
                else{
                    int sim = 0;
                    House house_1 = houseList.get(x);
                    House house_2 = houseList.get(y);

                    if(house_1.getLocation().equals(house_2.getLocation())) sim += 10;

                    int diff = Math.abs(house_1.getPrice()-house_2.getPrice());
                    if( diff <= 1000) sim+=10;
                    else if(diff <= 5000 && diff > 1000) sim+=5;
                    else if(diff <= 10000 && diff > 5000) sim += 1;


                    double distance = measureDistance(Double.valueOf(house_1.getLatitude()),Double.valueOf(house_1.getLongitude()),Double.valueOf(house_2.getLatitude()),Double.valueOf(house_2.getLongitude()));
                    if(distance <= 2.0) sim+= 10;
                    else if(distance <= 5.0 && distance > 2.0) sim += 5;
                    else if(distance <= 10 && distance > 5.0) sim += 1;

                }
        }
        return similarity;


    }

    public List<House> getHouseList(List<Integer> idList){
        List<House> houseList = new ArrayList<>();
        for(int i = 0;i < idList.size();i++){
            houseList.add(houseService.findHouseByIdService(idList.get(i)));
        }
        return houseList;
    }


    public double measureDistance(double lat_a ,double log_a, double lat_b,double log_b){
        double a = lat_a - lat_b;
        double b = log_a - log_b;
        return  2 * 6378.137 * Math.asin(Math.sqrt( Math.sin(a/2) * Math.sin(a/2) + Math.cos(lat_a) * Math.cos(lat_b) * Math.sin(b/2) * Math.sin(b/2)));
    }




}

