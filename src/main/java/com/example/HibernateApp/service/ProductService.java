package com.example.HibernateApp.service;

import com.example.HibernateApp.entity.Product;
import com.example.HibernateApp.repository.ProductRepositori;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositori productRepositori;

    public Product createProduct(Product product) {
        return productRepositori.save(Product.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build());
    }
}
