package com.hit.secondhouse.controller;

import com.google.gson.Gson;
import com.hit.secondhouse.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/map")
public class MapController {

    @Autowired
    public HouseService houseService;

    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String index(@RequestParam(value = "callback",required = false) String callback , @PathVariable("id") int id) {
        Map map = new HashMap();
        map.put("lng",houseService.findHouseByIdService(id).getLongitude());
        map.put("lat",houseService.findHouseByIdService(id).getLatitude());
        Gson gson = new Gson();
        return callback+"("+gson.toJson(map)+")";
    }



}
