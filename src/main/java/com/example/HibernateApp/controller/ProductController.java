package com.example.HibernateApp.controller;

import com.example.HibernateApp.dto.BaseSuccessResponse;
import com.example.HibernateApp.dto.ProductDto;
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
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    private ResponseEntity<Product> postProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService
                .createProduct(productDto), HttpStatus.OK);
    }

    @GetMapping("/list")
    private ResponseEntity<List<Product>> getProduct() {
        return new ResponseEntity<>(productService.getProductList(),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Boolean> putProduct(@RequestBody ProductDto productDto,
                                               @PathVariable Long id) {
        return new ResponseEntity<>(productService.putProduct(id, productDto),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    private ResponseEntity<Product> patchProduct(@RequestBody ProductDto productDto,
                                                 @PathVariable Long id) {
        return new ResponseEntity<>(productService.patchProduct(id, productDto),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<BaseSuccessResponse> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(
                new BaseSuccessResponse(productService.deleteProduct(id)),
                HttpStatus.OK);
    }
}
