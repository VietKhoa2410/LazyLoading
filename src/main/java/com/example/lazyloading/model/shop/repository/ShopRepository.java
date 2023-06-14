package com.example.lazyloading.model.shop.repository;

import com.example.lazyloading.model.shop.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
}
