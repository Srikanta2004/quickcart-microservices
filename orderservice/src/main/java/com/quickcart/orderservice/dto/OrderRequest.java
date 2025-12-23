package com.quickcart.orderservice.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequest {
    private Long userId;
    private List<OrderItemDto> items;
}
