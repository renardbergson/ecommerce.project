package com.project.ecommerce.project.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/admin/user")
    public String user(Model model) {
        model.addAttribute("adminSection", "user");
        return "admin";
    }
}
