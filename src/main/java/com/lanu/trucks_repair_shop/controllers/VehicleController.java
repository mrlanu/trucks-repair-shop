package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.entities.Trailer;
import com.lanu.trucks_repair_shop.entities.Truck;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehiclesList")
    public String unitsList(Model model){
        model.addAttribute("vehiclesList", vehicleService.findAll());
        return "vehiclesList";
    }

    @GetMapping("/showVehicle")
    public String showVehicle(@RequestParam("type") String type, @RequestParam("number") Integer number, Model model){
        if (type.equalsIgnoreCase("Truck")){
            Truck truck = (Truck) vehicleService.findByNumber(number);
            model.addAttribute("vehicle", truck);
            return "truck";
        }else {
            Trailer trailer = (Trailer) vehicleService.findByNumber(number);
            model.addAttribute("vehicle", trailer);
            return "trailer";
        }
    }
}
