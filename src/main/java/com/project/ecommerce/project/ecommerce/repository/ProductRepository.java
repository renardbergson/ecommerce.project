package com.project.ecommerce.project.ecommerce.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.project.ecommerce.project.ecommerce.models.Product;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {
}
