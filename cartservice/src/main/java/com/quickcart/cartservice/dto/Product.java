package com.quickcart.cartservice.dto;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String category;
    private String image;
}
