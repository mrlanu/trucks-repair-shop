package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.entities.Trailer;
import com.lanu.trucks_repair_shop.entities.Truck;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehiclesList")
    public String unitsList(Model model){
        model.addAttribute("vehiclesList", vehicleService.findAll());
        return "vehiclesList";
    }

    @GetMapping("/showFormForNewTruck")
    public String addTruck(Model model){
        Truck truck = new Truck();
        truck.setType("Truck");
        model.addAttribute("truck", truck);
        model.addAttribute("what", "new");
        return "truck";
    }

    @GetMapping("/showFormForNewTrailer")
    public String addTrailer(Model model){
        Trailer trailer = new Trailer();
        trailer.setType("Trailer");
        model.addAttribute("trailer", trailer);
        model.addAttribute("what", "new");
        return "trailer";
    }

    @GetMapping("/showFormForEditVehicle")
    public String showVehicle(@RequestParam("type") String type, @RequestParam("number") Integer number, Model model){

        model.addAttribute("what", "edit");

        if (type.equalsIgnoreCase("Truck")){
            Truck truck = (Truck) vehicleService.findByNumber(number);
            model.addAttribute("truck", truck);
            return "truck";
        }else {
            Trailer trailer = (Trailer) vehicleService.findByNumber(number);
            model.addAttribute("trailer", trailer);
            return "trailer";
        }
    }

    @PostMapping("/saveTruck")
    public String addNewTruckPost(@Valid Truck truck, BindingResult bindingResult, @RequestParam("param") String what, Model model){

        model.addAttribute("what", what);

        if (bindingResult.hasErrors()){
            return "truck";
        }
        if (what.equalsIgnoreCase("new")) {
            if (vehicleService.isVehiclePresent(truck)) {
                model.addAttribute("exist", true);
                return "truck";
            }
        }
        vehicleService.save(truck);

        return "redirect:/vehiclesList";
    }

    @PostMapping("/saveTrailer")
    public String saveTrailer(@Valid Trailer trailer, BindingResult bindingResult, @RequestParam("param") String what, Model model){

        model.addAttribute("what", what);

        if (bindingResult.hasErrors()){
            return "trailer";
        }
        if (what.equalsIgnoreCase("new")) {
            if (vehicleService.isVehiclePresent(trailer)) {
                model.addAttribute("exist", true);
                return "trailer";
            }
        }
        vehicleService.save(trailer);

        return "redirect:/vehiclesList";
    }

    @GetMapping("/deleteVehicle")
    public String deleteVehicle(@RequestParam("number") Integer number){
        vehicleService.deleteVehicle(number);
        return "redirect:/vehiclesList";
    }
}
