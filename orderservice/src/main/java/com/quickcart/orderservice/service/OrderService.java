package com.quickcart.orderservice.service;

import com.quickcart.orderservice.dto.CartItemDto;
import com.quickcart.orderservice.model.Order;
import com.quickcart.orderservice.model.OrderItem;
import com.quickcart.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartServiceClient cartServiceClient;

    public Order placeOrder(Long userId) {
        // 1. Fetch cart items
        List<CartItemDto> cartItems = cartServiceClient.getCartItems(userId);

        // 2. Convert to order
        Order order = new Order();
        order.setUserId(userId);

        for (CartItemDto cartItem : cartItems) {
            OrderItem item = new OrderItem();
            item.setProductId(cartItem.getProductId());
            item.setQuantity(cartItem.getQuantity());
            item.setOrder(order);
            order.getItems().add(item);
        }

        // 3. Save in DB
        Order savedOrder = orderRepository.save(order);

        // 4. Clear cart
        cartServiceClient.clearCart(userId);

        return savedOrder;
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
