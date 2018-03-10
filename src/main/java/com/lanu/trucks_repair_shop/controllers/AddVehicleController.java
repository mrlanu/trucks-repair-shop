package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.entities.Truck;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddVehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/addNewTruck")
    public String addTruck(Model model){
        Truck truck = new Truck();
        truck.setType("Truck");
        model.addAttribute("truck", truck);
        return "addNewTruck";
    }

    @PostMapping("/addNewTruck")
    public String addNewTruckPost(@Valid Truck truck, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "addNewTruck";
        }
        if (vehicleService.isVehiclePresent(truck)){
            model.addAttribute("exist", true);
            return "addNewTruck";
        }
        vehicleService.save(truck);
        return "redirect:/vehiclesList";
    }
}
