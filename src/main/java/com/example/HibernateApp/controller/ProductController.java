package com.example.HibernateApp.controller;

import com.example.HibernateApp.entity.Product;
import com.example.HibernateApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    private ResponseEntity<Product> postProduct(@RequestBody Product product) {

        return new ResponseEntity<>(productService
                .createProduct(product), HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<Product> getProduct() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Product> putProduct() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Product> patchProduct() {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Product> deleteProduct() {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
