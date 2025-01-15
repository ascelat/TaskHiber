package com.example.HibernateApp.service;

import com.example.HibernateApp.entity.Product;
import com.example.HibernateApp.repository.ProductRepositori;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositori productRepositori;

    public Product createProduct(String name, Long price) {
        return productRepositori.save(new Product(name, price));
    }

    public List<Product> getProductList() {
        return productRepositori.findAll();
    }
}
