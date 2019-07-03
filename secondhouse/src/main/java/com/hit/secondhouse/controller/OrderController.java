package com.hit.secondhouse.controller;


import com.hit.secondhouse.service.AdminService;
import com.hit.secondhouse.service.OrderformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    public OrderformService orderformService;

    @RequestMapping(value = "/buy",method = RequestMethod.GET)
    public void register(@RequestParam(value = "uid") int uid , @RequestParam("hid") int hid,@RequestParam("price") int price){
        int id = 0;
        orderformService.addOrderService(id,uid,hid,price);

    }

}
