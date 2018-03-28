package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.domain.vehicle.Make;
import com.lanu.trucks_repair_shop.domain.vehicle.Trailer;
import com.lanu.trucks_repair_shop.domain.vehicle.Truck;
import com.lanu.trucks_repair_shop.repositories.MakeRepository;
import com.lanu.trucks_repair_shop.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MakeRepository makeRepository;

    @GetMapping("/vehiclesList")
    public String unitsList(Model model){
        model.addAttribute("vehiclesList", vehicleService.findAll());
        return "vehicle/vehiclesList";
    }

    @GetMapping("/showFormForNewTruck")
    public String addTruck(Model model){
        Truck truck = new Truck();
        truck.setType("Truck");
        model.addAttribute("truck", truck);
        model.addAttribute("what", "new");
        List<Make> makeList = makeRepository.findByTypeOfVehicle("Truck");
        model.addAttribute("makeList", makeList);
        return "vehicle/truck";
    }

    @GetMapping("/showFormForNewTrailer")
    public String addTrailer(Model model){
        Trailer trailer = new Trailer();
        trailer.setType("Trailer");
        model.addAttribute("trailer", trailer);
        model.addAttribute("what", "new");
        List<Make> makeList = makeRepository.findByTypeOfVehicle("Trailer");
        model.addAttribute("makeList", makeList);
        return "vehicle/trailer";
    }

    @GetMapping("/showFormForEditVehicle")
    public String showVehicle(@RequestParam("type") String type, @RequestParam("number") Integer number, Model model){

        model.addAttribute("what", "edit");

        if (type.equalsIgnoreCase("Truck")){
            Truck truck = (Truck) vehicleService.findByNumber(number);
            model.addAttribute("makeName", truck.getMake().getName());
            model.addAttribute("truck", truck);
            List<Make> makeList = makeRepository.findByTypeOfVehicle("Truck");
            model.addAttribute("makeList", makeList);
            return "vehicle/truck";
        }else {
            Trailer trailer = (Trailer) vehicleService.findByNumber(number);
            model.addAttribute("makeName", trailer.getMake().getName());
            model.addAttribute("trailer", trailer);
            List<Make> makeList = makeRepository.findByTypeOfVehicle("Trailer");
            model.addAttribute("makeList", makeList);
            return "vehicle/trailer";
        }
    }

    @PostMapping("/saveTruck")
    public String addNewTruckPost(@Valid Truck truck, BindingResult bindingResult,
                                  @ModelAttribute("makeName") String makeName,
                                  @RequestParam("param") String what, Model model){

        model.addAttribute("what", what);
        List<Make> makeList = makeRepository.findByTypeOfVehicle("Truck");
        model.addAttribute("makeList", makeList);

        if (bindingResult.hasErrors()){
            return "vehicle/truck";
        }
        if (what.equalsIgnoreCase("new")) {
            if (vehicleService.isVehiclePresent(truck)) {
                model.addAttribute("exist", true);
                return "vehicle/truck";
            }
        }

        vehicleService.save(truck, makeName);

        return "redirect:/vehicles/vehiclesList";
    }

    @PostMapping("/saveTrailer")
    public String saveTrailer(@Valid Trailer trailer, BindingResult bindingResult,
                              @ModelAttribute("makeName") String makeName,
                              @RequestParam("param") String what, Model model){

        model.addAttribute("what", what);
        List<Make> makeList = makeRepository.findByTypeOfVehicle("Trailer");
        model.addAttribute("makeList", makeList);

        if (bindingResult.hasErrors()){
            return "vehicle/trailer";
        }
        if (what.equalsIgnoreCase("new")) {
            if (vehicleService.isVehiclePresent(trailer)) {
                model.addAttribute("exist", true);
                return "vehicle/trailer";
            }
        }
        vehicleService.save(trailer, makeName);

        return "redirect:/vehicles/vehiclesList";
    }

    @GetMapping("/deleteVehicle")
    public String deleteVehicle(@RequestParam("number") Integer number){
        vehicleService.deleteVehicle(number);
        return "redirect:/vehicles/vehiclesList";
    }

    @ModelAttribute("singleSelectAllValues")
    public String[] getSingleSelectAllValues() {
        return new String[] {"YES", "NO"};
    }
}
