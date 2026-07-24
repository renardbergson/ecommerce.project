package com.project.ecommerce.project.ecommerce.controller;

import com.project.ecommerce.project.ecommerce.models.Product;
import com.project.ecommerce.project.ecommerce.repository.ProductRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String category) {
        Iterable<Product> products;
        Product.Category selectedCategory = null;

        if(category != null && !category.isBlank()) {
            try {
                selectedCategory = Product.Category.valueOf(category.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category: " + category);
                return "redirect:/";
            }
        }

        if(selectedCategory != null) {
            products = productRepository.findByCategory(selectedCategory);
        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("categories", Product.Category.values());
        model.addAttribute("products", products);
        model.addAttribute("categoryFilter", selectedCategory);
        return "index";
    }
}
