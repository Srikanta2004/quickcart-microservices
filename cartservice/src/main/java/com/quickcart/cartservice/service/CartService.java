package com.quickcart.cartservice.service;

import com.quickcart.cartservice.dto.Product;
import com.quickcart.cartservice.dto.CartItemResponse;
import com.quickcart.cartservice.model.Cart;
import com.quickcart.cartservice.model.CartItem;
import com.quickcart.cartservice.repository.CartItemRepository;
import com.quickcart.cartservice.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String PRODUCT_SERVICE_URL = "http://localhost:8081/products"; // Product service URL

    public Cart getCartByUser(String email) {
        return cartRepository.findByUserEmail(email).orElseGet(() -> {
            Cart cart = new Cart();
            cart.setUserEmail(email);
            cart.setItems(new ArrayList<>());
            return cartRepository.save(cart);
        });
    }

    public Cart addItemToCart(String email, Long productId, int quantity) {
        Cart cart = getCartByUser(email);
        for (CartItem item : cart.getItems()) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(item.getQuantity() + quantity);
                cartRepository.save(cart);
                return cart;
            }
        }

        CartItem newItem = CartItem.builder()
                .productId(productId)
                .quantity(quantity)
                .cart(cart)
                .build();

        cart.getItems().add(newItem);
        cartRepository.save(cart);

        return cart;
    }

    public Cart removeItemFromCart(String email, Long itemId) {
        Cart cart = getCartByUser(email);
        cart.getItems().removeIf(item -> item.getId().equals(itemId));
        cartRepository.save(cart);
        return cart;
    }

    public void clearCart(String email) {
        Cart cart = getCartByUser(email);
        cart.getItems().clear();
        cartRepository.save(cart);
    }


    public List<CartItemResponse> getCartItemsWithDetails(String email) {
        Cart cart = getCartByUser(email);

        List<CartItemResponse> responseList = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = restTemplate.getForObject(
                    PRODUCT_SERVICE_URL + "/" + item.getProductId(),
                    Product.class
            );

            CartItemResponse response = new CartItemResponse(
                    item.getId(),
                    item.getQuantity(),
                    product
            );

            responseList.add(response);
        }

        return responseList;
    }
}
