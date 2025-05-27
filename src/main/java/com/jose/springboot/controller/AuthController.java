package com.jose.springboot.controller;

import com.jose.springboot.dto.RegistrationDto;
import com.jose.springboot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Handler method to show registration page
    @GetMapping("/auth/register")
    public String showRegistrationForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "auth/register";
    }

    // Handler method to handle user registration form submission
    @PostMapping("/auth/register/save")
    public String registerUserAccount(@Valid @ModelAttribute("user") RegistrationDto user,
                                      BindingResult result,
                                      Model model) {


        // Check if the email already exists
        if (userService.emailExists(user.getEmail())) {
            result.rejectValue("email", null, "Account already exists");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "auth/register";
        }

        userService.saveUser(user);
        return "redirect:/auth/register?success";
    }

    // Handler method to show login page
    @GetMapping("/auth/login")
    public String showLoginPage(Model model) {
        return "auth/login";
    }

}
