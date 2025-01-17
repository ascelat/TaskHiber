package com.example.HibernateApp.service;

import com.example.HibernateApp.dto.ProductDto;
import com.example.HibernateApp.entity.Product;
import com.example.HibernateApp.repository.ProductRepositori;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepositori productRepositori;

    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return productRepositori.save(product);
    }

    @Transactional
    public Boolean putProduct(Long id, ProductDto productDto) {
        Product product = productRepositori.findById(id)
                .orElseThrow(() -> new RuntimeException("Нет такого продукта"));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());

        return true;
    }

    @Transactional
    public Product patchProduct(Long id, ProductDto productDto) {
        Product product = productRepositori.findById(id)
                .orElseThrow(() -> new RuntimeException("Нет такого продукта"));

        if(productDto.getName() != null &&
                !productDto.getName().isEmpty() && !productDto.getName().isBlank()) {
            product.setName(productDto.getName());
        }
        if(productDto.getPrice() != null) {
            product.setPrice(productDto.getPrice());
        }

        return productRepositori.save(product);
    }

    public List<Product> getProductList() {
        return productRepositori.findAll();
    }

    @Transactional
    public boolean deleteProduct(Long id) {
        productRepositori.deleteById(id);
        return true;
    }
}
