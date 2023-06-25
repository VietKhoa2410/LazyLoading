package com.example.lazyloading.model.product.repository;

import com.example.lazyloading.model.product.dto.ProductDto;
import com.example.lazyloading.model.product.dto.ProductInfo;
import com.example.lazyloading.model.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    <T> T findById(Long id, Class<T> tClass);

    @Query("select new com.example.lazyloading.model.product.dto.ProductDto(p.id, p.name, p.shop.id, p.shop.name)  from ProductEntity p where p.shop.name like %:name%")
    List<ProductDto> findProductDtoByNameLike(String name);

    List<ProductInfo> findByShopNameContaining(String name);
}
