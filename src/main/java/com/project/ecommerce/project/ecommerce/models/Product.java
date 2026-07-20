package com.project.ecommerce.project.ecommerce.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Product {
    public enum Category {
        ELECTRONICS("Eletrônicos", "fa-mobile-alt"),
        CLOTHING("Roupas", "fa-tshirt"),
        HOME_GARDEN("Casa & Jardim", "fa-chair"),
        SPORTS("Esportes", "fa-running"),
        TOYS("Brinquedos", "fa-puzzle-piece"),
        BEAUTY("Beleza", "fa-magic"),
        AUTOMOTIVE("Automotivo", "fa-car");

        private final String description;
        private final String icon;

        Category(String description, String icon) {
            this.description = description;
            this.icon = icon;
        }

        public String getDescription() {
            return description;
        }

        public String getIcon() {
            return icon;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Double price;
    private String status;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
