package com.quickcart.orderservice.service;

import com.quickcart.orderservice.dto.CartItemDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CartServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String CART_SERVICE_URL = "http://localhost:8080/api/cart";

    // 1. Fetch cart items from CartService
    public List<CartItemDto> getCartItems(Long userId) {
        CartItemDto[] cartItems = restTemplate.getForObject(
                CART_SERVICE_URL + "/" + userId,
                CartItemDto[].class
        );
        return Arrays.asList(cartItems);
    }

    // 2. Clear cart after order
    public void clearCart(Long userId) {
        restTemplate.delete(CART_SERVICE_URL + "/" + userId + "/clear");
    }
}
