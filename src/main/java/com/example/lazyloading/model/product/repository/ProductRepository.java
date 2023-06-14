package com.example.lazyloading.model.product.repository;

import com.example.lazyloading.model.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
