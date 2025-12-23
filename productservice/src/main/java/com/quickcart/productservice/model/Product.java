package com.quickcart.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
}
