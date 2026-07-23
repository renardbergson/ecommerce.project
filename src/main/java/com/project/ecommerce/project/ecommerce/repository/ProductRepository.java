package com.project.ecommerce.project.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import com.project.ecommerce.project.ecommerce.models.Product;

import java.util.UUID;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, UUID> {
    List<Product> findByCategory(Product.Category category);
}
