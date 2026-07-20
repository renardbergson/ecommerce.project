package com.project.ecommerce.project.ecommerce.controller;

import com.project.ecommerce.project.ecommerce.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String category) {
        Product.Category selectedCategory = null;

        if(category != null && !category.isBlank()) {
            try {
                selectedCategory = Product.Category.valueOf(category.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category: " + category);
                return "redirect:/";
            }
        }

        model.addAttribute("categories", Product.Category.values());
        model.addAttribute("categoryFilter", selectedCategory);
        return "index";
    }
}
