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

    @ModelAttribute("makeListTruck")
    public List<Make> makeListTruck(){
        return makeRepository.findByTypeOfVehicle("Truck");
    }

    @ModelAttribute("makeListTrailer")
    public List<Make> makeListTrailer(){
        return makeRepository.findByTypeOfVehicle("Trailer");
    }

    @GetMapping("/vehiclesList")
    public String unitsList(Model model){
        model.addAttribute("vehiclesList", vehicleService.findAll());
        return "vehicle/vehiclesList";
    }

    @GetMapping("/showFormForNewTruck")
    public String addTruck(Model model){
        model.addAttribute("truck", new Truck("Truck"));
        model.addAttribute("what", "new");
        return "vehicle/truck";
    }

    @GetMapping("/showFormForNewTrailer")
    public String addTrailer(Model model){
        model.addAttribute("trailer", new Trailer("Trailer"));
        model.addAttribute("what", "new");
        return "vehicle/trailer";
    }

    @GetMapping("/showFormForEditVehicle")
    public String showVehicle(@RequestParam("type") String type, @RequestParam("number") Integer number, Model model){

        model.addAttribute("what", "edit");

        if (type.equalsIgnoreCase("Truck")){
            model.addAttribute("truck", (Truck) vehicleService.findByNumber(number));
            return "vehicle/truck";
        }else {
            model.addAttribute("trailer", (Trailer) vehicleService.findByNumber(number));
            return "vehicle/trailer";
        }
    }

    @PostMapping("/saveTruck")
    public String addNewTruckPost(@Valid Truck truck, BindingResult bindingResult,
                                  @RequestParam("param") String what, Model model){

        model.addAttribute("what", what);

        if (bindingResult.hasErrors()){
            return "vehicle/truck";
        }
        if (what.equalsIgnoreCase("new")) {
            if (vehicleService.isVehiclePresent(truck)) {
                model.addAttribute("exist", true);
                return "vehicle/truck";
            }
        }

        vehicleService.save(truck);

        return "redirect:/vehicles/vehiclesList";
    }

    @PostMapping("/saveTrailer")
    public String saveTrailer(@Valid Trailer trailer, BindingResult bindingResult,
                              @RequestParam("param") String what, Model model){

        model.addAttribute("what", what);

        if (bindingResult.hasErrors()){
            return "vehicle/trailer";
        }
        if (what.equalsIgnoreCase("new")) {
            if (vehicleService.isVehiclePresent(trailer)) {
                model.addAttribute("exist", true);
                return "vehicle/trailer";
            }
        }
        vehicleService.save(trailer);

        return "redirect:/vehicles/vehiclesList";
    }

    @GetMapping("/deleteVehicle")
    public String deleteVehicle(@RequestParam("number") Integer number){
        vehicleService.deleteVehicle(number);
        return "redirect:/vehicles/vehiclesList";
    }

    @GetMapping("/getModelListByMake")
    @ResponseBody
    public List<com.lanu.trucks_repair_shop.domain.vehicle.Model> getModelListByMake(@RequestParam("makeId")Integer makeId){
        Make make = makeRepository.findByMakeId(makeId);
        return make.getModelList();
    }

    /*@ModelAttribute("singleSelectAllValues")
    public String[] getSingleSelectAllValues() {
        return new String[] {"YES", "NO"};
    }*/
}
