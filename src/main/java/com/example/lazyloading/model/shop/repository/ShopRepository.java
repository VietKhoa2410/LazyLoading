package com.example.lazyloading.model.shop.repository;

import com.example.lazyloading.model.shop.dto.ShopInfo;
import com.example.lazyloading.model.shop.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

  @Query("select s.id as id, s.name as name from ShopEntity s where s.id=:id")
  ShopInfo findInfoById(Long id);
}
