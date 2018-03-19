package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.domain.security.Role;
import com.lanu.trucks_repair_shop.domain.security.User;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RegisterUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user/userRegistrationForm";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model){
        user.addRole(new Role("USER"));
        userService.createUser(user);
        model.addAttribute("success", true);
        User userForModel = userService.findByUsername(user.getUsername());
        model.addAttribute("user", userForModel);
        return "loginForm";
    }

}
