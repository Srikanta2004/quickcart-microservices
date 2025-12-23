package com.quickcart.productservice.service;

import com.quickcart.productservice.model.Product;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Data
@Service
public class ProductService {
    private final String BASE_URL = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate = new RestTemplate();

    public Product[] getAllProducts() {

        return restTemplate.getForObject(BASE_URL, Product[].class);
    }

    public Product getProductById(int id) {
        
        return restTemplate.getForObject(BASE_URL + "/" + id, Product.class);
    }
}
