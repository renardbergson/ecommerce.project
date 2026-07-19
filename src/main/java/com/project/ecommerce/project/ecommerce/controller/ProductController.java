package com.project.ecommerce.project.ecommerce.controller;

import com.project.ecommerce.project.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.project.ecommerce.project.ecommerce.models.Product;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("adminSection", "product");
        model.addAttribute("products", productRepository.findAll());
        return "admin";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product) {
        productRepository.save(product);
        System.out.println(product);
        return "redirect:/admin/product";
    }
}
