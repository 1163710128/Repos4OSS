package com.hit.secondhouse.recommendSystem;

import java.util.ArrayList;
import java.util.List;

public class RecommendTest {
    public static void main(String[] args){
        Recommender recommender = new Recommender();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(recommender.getRecommended(recommender.getHouseList(list)));

    }
}
