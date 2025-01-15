package com.example.HibernateApp.repository;

import com.example.HibernateApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositori extends JpaRepository<Product, Long> {
}
