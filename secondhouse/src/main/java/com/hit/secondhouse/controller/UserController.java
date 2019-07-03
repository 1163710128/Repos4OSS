package com.hit.secondhouse.controller;


import com.hit.secondhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){return "user center is saying hello";}

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(@RequestParam(value = "password",required = true) String password, @RequestParam("name") String name){
        int id = 0;
        userService.insertService(id,name,password);
    }

    /*
    @RequestMapping(value = "/login/{name}/{password}",method = RequestMethod.GET)
        public String login(@PathVariable("password") String password, @PathVariable("name") String name){
            if(userService.selectService(name).getPassword().equals(password)){
                return "login success";
            }else{
                return "login failed,check your password";
            }
    }*/

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam(value = "password") String password, @RequestParam(value = "name") String name){
        //Map<String,String> map = new HashMap<String,String>();
        if(userService.selectService(name).getPassword().equals(password)){
            //map.put("msg","loginsuccess");
            return "<h1>loginsuccess</h1>";
        }else{
            //map.put("msg","loginfailed");
            return "<h1>logininfailed</h1>";
        }
    }

    @RequestMapping(value = "/resetpassword/{name}",method = RequestMethod.GET)
    public void resetPassword(@PathVariable("name") String name, @RequestParam(value = "password",required = true) String password){
        userService.setPasswordByNameService(name,password);
    }

    @RequestMapping(value = "/deleteUserById",method = RequestMethod.GET)
    public void deleteUserById(@RequestParam(value = "id") int id){
        userService.deleteUserById(id);
    }
}
