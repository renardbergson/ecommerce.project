package com.project.ecommerce.project.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductsController {
    @GetMapping("/admin/products")
    public String dashboard(Model model) {
        model.addAttribute("adminSection", "products");
        return "admin";
    }
}
