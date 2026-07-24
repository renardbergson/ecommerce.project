package com.project.ecommerce.project.ecommerce.controller;

import com.project.ecommerce.project.ecommerce.repository.ProductRepository;
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
    private final ProductRepository productRepository;

    ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product")
    public String product(Model model, @RequestParam(required = false) String category) {
        Iterable<Product> products;
        Product.Category selectedCategory = null;

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

        if(category != null && !category.isBlank()) {
            try {
                selectedCategory = Product.Category.valueOf(category.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category: " + category);
                return "redirect:/admin/product";
            }
        }

        if(selectedCategory != null) {
            products = productRepository.findByCategory(selectedCategory);
        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("products", products);
        model.addAttribute("categories", Product.Category.values());
        model.addAttribute("categoryFilter", selectedCategory);
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
