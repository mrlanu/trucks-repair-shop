package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.domain.Breaking;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/breaking")
public class BreakingController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/breakingList")
    public String breakingList(@RequestParam("number") Integer number, @RequestParam("type") String type, Model model){
        Vehicle vehicle = vehicleService.findByNumber(number);
        List<Breaking> breakingList = vehicle.getBreakingList();
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("breakingList", breakingList);
        return "breaking/breakingList";
    }
}
