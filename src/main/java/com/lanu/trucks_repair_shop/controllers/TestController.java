package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/test")
    public Vehicle getTest(){
        return vehicleService.findByNumber(12345);
    }
}
