package com.project.ecommerce.project.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/auth/login")
    public String login() {
        return "signin";
    }

    @GetMapping("/auth/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("auth/logout")
    public String logout() {
        return "redirect:/";
    }
}
