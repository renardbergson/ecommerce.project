package com.project.ecommerce.project.ecommerce.controller;

import com.project.ecommerce.project.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.project.ecommerce.project.ecommerce.models.Product;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String product(Model model) {
        if(model.containsAttribute("product")) {
            model.addAttribute("product", model.getAttribute("product"));
        } else {
            model.addAttribute("product", new Product());
        }

        if(model.containsAttribute("adminSection")) {
            model.addAttribute("adminSection", model.getAttribute("adminSection"));
        } else {
            model.addAttribute("adminSection", "product");
        }

        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("categories", Product.Category.values());
        return "admin";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product) {
        productRepository.save(product);
        System.out.println(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/product/edit/{id}")
    public String edit(@PathVariable UUID id, RedirectAttributes redirectAttributes) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            redirectAttributes.addFlashAttribute("product", product.get());
        } else {
            System.out.println("Product not found! " + id);
        }
        return "redirect:/admin/product";
    }

    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable UUID id, RedirectAttributes redirectAttributes) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            redirectAttributes.addFlashAttribute("product", product.get());
            redirectAttributes.addFlashAttribute("adminSection", "confirm-delete-product");
        }
        return "redirect:/admin/product";
    }

    @GetMapping("/product/delete/{id}/confirm")
    public String confirmDelete(@PathVariable UUID id) {
        productRepository.deleteById(id);
        System.out.println("Product deleted from database: " + id);
        return "redirect:/admin/product";
    }
}
