package com.quickcart.cartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemResponse {
    private Long itemId;
    private int quantity;
    private Product product;
}
