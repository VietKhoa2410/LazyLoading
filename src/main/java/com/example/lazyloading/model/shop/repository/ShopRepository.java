package com.example.lazyloading.model.shop.repository;

import com.example.lazyloading.model.shop.entity.ShopEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {
  ShopEntity findByName(String name);
}
