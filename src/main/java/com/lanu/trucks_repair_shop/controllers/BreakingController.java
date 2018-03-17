package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/breaking")
public class BreakingController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/breakingList")
    public String breakingListt(@RequestParam("number") Integer number, @RequestParam("type") String type, Model model){
        Vehicle vehicle = vehicleService.findByNumber(number);
        model.addAttribute("vehicle", vehicle);
        return "breaking/breakingList";
    }
}
