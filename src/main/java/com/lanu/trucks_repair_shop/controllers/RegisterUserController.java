package com.lanu.trucks_repair_shop.controllers;

import com.lanu.trucks_repair_shop.domain.security.Users;
import com.lanu.trucks_repair_shop.services.security_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class RegisterUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        Users user = new Users();
        model.addAttribute("users", user);
        return "user/userRegistrationForm";
    }

    @PostMapping("/register")
    public String registerUser(@Valid Users user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "user/userRegistrationForm";
        }

        if (userService.findByUsername(user.getUsername()) != null){
            model.addAttribute("usernameExists", true);
            return "user/userRegistrationForm";
        }

        userService.createUser(user);

        Users userForModel = userService.findByUsername(user.getUsername());
        model.addAttribute("user", userForModel);
        model.addAttribute("success", true);

        return "loginForm";
    }

}
