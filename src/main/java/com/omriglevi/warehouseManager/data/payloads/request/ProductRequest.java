package com.omriglevi.warehouseManager.data.payloads.request;
import com.omriglevi.warehouseManager.data.models.Category;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ProductRequest {
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String color;
    @NotBlank
    @NotNull
    private String brand;
    @Email
    private Integer qtyInStock;
    @NotBlank
    @NotNull
    private double price;
    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public Integer getQtyInStock() {
        return qtyInStock;
    }
    public void setQtyInStock(Integer qtyInStock) {
        this.qtyInStock = qtyInStock;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}