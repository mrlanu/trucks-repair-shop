package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.domain.breaking.Breaking;
import com.lanu.trucks_repair_shop.domain.breaking.BreakingDetail;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import com.lanu.trucks_repair_shop.repositories.BreakingRepository;
import com.lanu.trucks_repair_shop.services.VehicleService;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import com.lanu.trucks_repair_shop.util.KindOfBreaking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/breaking")
public class BreakingController {

    @Autowired
    private UserService userService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private KindOfBreaking kindOfBreaking;

    @Autowired
    private BreakingRepository breakingRepository;

    @GetMapping("/breakingList")
    public String breakingList(@RequestParam("number") Integer number,
                               Model model){
        Vehicle vehicle = vehicleService.findByNumber(number);
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("breakingList", vehicle.getBreakingList());
        return "breaking/breakingList";
    }

    @GetMapping("/showFormForAddBreaking")
    public String addBreaking(@RequestParam("type") String type,
                              @RequestParam("number") Integer number,
                              Model model){

        model.addAttribute("vehicle", vehicleService.findByNumber(number));
        model.addAttribute("breaking", new Breaking());
        model.addAttribute("kindMap", kindOfBreaking.getKindMap());

        if (type.equalsIgnoreCase("Truck")){
            return "breaking/addBreakingTruck";

        }else {
            return "breaking/addBreakingTrailer";
        }
    }

    @PostMapping("/saveBreaking")
    public String saveBreaking(@Valid Breaking breaking,
                               BindingResult bindingResult,
                               @RequestParam("vehicleNumber")Integer vehicleNumber,
                               @RequestParam(value = "breakingKind", required = false)Integer[] breakingKind,
                               @RequestParam(value = "descriptionList", required = false)String[] descriptionList,
                               Model model,
                               Principal principal){
        if (bindingResult.hasErrors()){
            model.addAttribute("vehicle", vehicleService.findByNumber(vehicleNumber));
            model.addAttribute("kindMap", kindOfBreaking.getKindMap());
            return "breaking/addBreakingTruck";
        }
        vehicleService.createBreaking(breakingKind, descriptionList, vehicleNumber, principal, breaking);

        return "redirect:/vehicles/vehiclesList";
    }

    @GetMapping("/findDetails")
    @ResponseBody
    public List<BreakingDetail> findDetails(Integer id){
        Breaking breaking = breakingRepository.findByBreakingId(id);
        return breaking.getBreakingDetailList();
    }

    @GetMapping("/fixing")
    public String fixing(@RequestParam("id")Integer id, Model model){
        Breaking breaking = breakingRepository.findByBreakingId(id);
        model.addAttribute("vehicle", breaking.getVehicle());
        model.addAttribute("breaking", breaking);
        model.addAttribute("breakingDetails", breaking.getBreakingDetailList());
        return "breaking/fixingBreaking";
    }

    @PostMapping("/fixing")
    public String fixingPost(@RequestParam("brId")Integer breakingId,
                             Principal principal){
        vehicleService.fixingBreaking(breakingId, principal);
        return "redirect:/vehicles/vehiclesList";
    }
}
