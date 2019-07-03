package com.hit.secondhouse.controller;


import com.google.gson.Gson;
import com.hit.secondhouse.domain.House;
import com.hit.secondhouse.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    public AdminService adminService;

    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello from admin Service";
    }

    @RequestMapping("/getAllUnverified")
    @ResponseBody
    public String getAllUnverified(@RequestParam(value = "callback",required = false) String callback){
        Map map = new HashMap();
        List<House> houseList = adminService.getAllUnverified();
        map.put("unverifiedList",houseList);
        Gson gson = new Gson();
        return callback+"("+gson.toJson(map)+")";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam(value = "adminID") int adminId, @RequestParam(value = "employeeId") int emplyeeId){
        //Map<String,String> map = new HashMap<String,String>();
        if(adminService.findAdminByEidService(emplyeeId).getAdminId() == adminId){
            //map.put("msg","loginsuccess");
            return "<h1>loginsuccess</h1>";
        }else{
            //map.put("msg","loginfailed");
            return "<h1>logininfailed</h1>";
        }
    }

    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public void setVerifiedById(@Param(value = "id") int id){
        adminService.setVerifiedByIdService(id);
    }


}
