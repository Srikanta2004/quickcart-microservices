package com.quickcart.cartservice.controller;

import com.quickcart.cartservice.model.Cart;
import com.quickcart.cartservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{email}")
    public ResponseEntity<Cart> getCart(@PathVariable String email) {
        return ResponseEntity.ok(cartService.getCartByUser(email));
    }

    @PostMapping("/{email}/add")
    public ResponseEntity<String> addToCart(
            @PathVariable String email,
            @RequestParam Long productId,
            @RequestParam int quantity) {

        cartService.addItemToCart(email, productId, quantity);
        return ResponseEntity.ok("Item added to cart successfully!");
    }

    @DeleteMapping("/{email}/remove/{itemId}")
    public ResponseEntity<String> removeFromCart(@PathVariable String email, @PathVariable Long itemId) {
        cartService.removeItemFromCart(email, itemId);
        return ResponseEntity.ok("Item removed from cart successfully!");
    }

    @DeleteMapping("/{email}/clear")
    public ResponseEntity<String> clearCart(@PathVariable String email) {
        cartService.clearCart(email);
        return ResponseEntity.ok("Cart cleared successfully!");
    }
}
