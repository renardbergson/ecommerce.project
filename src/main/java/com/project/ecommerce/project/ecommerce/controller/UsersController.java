package com.project.ecommerce.project.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
    @GetMapping("/admin/users")
    public String dashboard(Model model) {
        model.addAttribute("adminSection", "users");
        return "admin";
    }
}
