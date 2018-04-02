package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.domain.breaking.Breaking;
import com.lanu.trucks_repair_shop.domain.breaking.BreakingDetail;
import com.lanu.trucks_repair_shop.domain.vehicle.Trailer;
import com.lanu.trucks_repair_shop.domain.vehicle.Truck;
import com.lanu.trucks_repair_shop.domain.vehicle.Vehicle;
import com.lanu.trucks_repair_shop.services.VehicleService;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import com.lanu.trucks_repair_shop.util.KindOfBreaking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/breaking")
public class BreakingController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private UserService userService;

    @Autowired
    private KindOfBreaking kindOfBreaking;

    @GetMapping("/breakingList")
    public String breakingList(@RequestParam("number") Integer number, @RequestParam("type") String type, Model model){
        Vehicle vehicle = vehicleService.findByNumber(number);
        List<Breaking> breakingList = vehicle.getBreakingList();
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("breakingList", breakingList);
        return "breaking/breakingList";
    }

    @GetMapping("/showFormForAddBreaking")
    public String addBreaking(@RequestParam("type") String type, @RequestParam("number") Integer number, Model model){

        model.addAttribute("breaking", new Breaking());
        model.addAttribute("kindMap", kindOfBreaking.getKindMap());

        if (type.equalsIgnoreCase("Truck")){
            model.addAttribute("vehicle", (Vehicle) vehicleService.findByNumber(number));
            return "breaking/addBreakingTruck";

        }else {
            model.addAttribute("vehicle", (Vehicle) vehicleService.findByNumber(number));
            return "breaking/addBreakingTrailer";
        }
    }

    @PostMapping("/saveBreaking")
    public String saveBreaking(@ModelAttribute("breaking")Breaking breaking,
                               @RequestParam("vehicleNumber")Integer vehicleNumber,
                               @RequestParam(value = "breakingKind", required = false)Integer[] breakingKind,
                               @RequestParam(value = "descriptionList", required = false)String[] descriptionList,
                               Principal principal,
                               Model model){

        Map<Integer, String> map = kindOfBreaking.getKindMap();
        Vehicle vehicle = vehicleService.findByNumber(vehicleNumber);
        List<BreakingDetail> breakingDetailList = Arrays.asList(breakingKind)
                .stream()
                .map(i -> new BreakingDetail(map.get(i), descriptionList[i]))
                .collect(Collectors.toList());

        breaking.setBreakingDetailList(breakingDetailList);
        breaking.setUserCreate(userService.findByUsername(principal.getName()));
        breaking.setDateCreate(new Date());
        vehicle.addBreaking(breaking);
        vehicle.setBroken(true);
        vehicleService.save(vehicle);
        return "redirect:/vehicles/vehiclesList";
    }
}
