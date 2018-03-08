package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.services.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping("/unitsList")
    public String unitsList(Model model, @RequestParam(defaultValue = "")String type){
        model.addAttribute("unitsList", unitService.findByTypeLike(type));
        return "unitsList";
    }
}
