package com.quickcart.orderservice.dto;

import lombok.Data;

@Data
public class CartItemDto {
    private Long productId;
    private int quantity;
}
