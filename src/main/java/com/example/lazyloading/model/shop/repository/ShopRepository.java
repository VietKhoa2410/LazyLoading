package com.example.lazyloading.model.shop.repository;

import com.example.lazyloading.model.shop.dto.ShopInfo;
import com.example.lazyloading.model.shop.entity.ShopEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

  ShopInfo findInfoById(Long id);

//  @EntityGraph(value = "Shop.products")
  List<ShopEntity> findByNameContains(String name);

}
