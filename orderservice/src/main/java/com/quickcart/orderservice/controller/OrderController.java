package com.quickcart.orderservice.controller;

import com.quickcart.orderservice.model.Order;
import com.quickcart.orderservice.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Tag(name = "Order Controller", description = "Manage user orders")
public class OrderController {

    private final OrderService orderService;

    @Operation(summary = "Place an order for a user")
    @PostMapping("/place/{userId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.placeOrder(userId));
    }

    @Operation(summary = "Get all orders for a user")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }
}
