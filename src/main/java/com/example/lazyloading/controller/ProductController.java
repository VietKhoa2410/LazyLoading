package com.example.lazyloading.controller;

import com.example.lazyloading.model.product.dto.ProductDto;
import com.example.lazyloading.model.product.dto.ProductInfo;
import com.example.lazyloading.model.product.entity.ProductEntity;
import com.example.lazyloading.model.product.service.ProductService;
import com.example.lazyloading.model.shop.entity.ShopEntity;
import com.example.lazyloading.model.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ShopService shopService;

    @GetMapping("{id}")
    public String findNameById(@PathVariable Long id){
        return productService.findById(id).getName();
    }

    @GetMapping("{id}/info")
    public ProductInfo findInfoById(@PathVariable Long id){
        return productService.findById(id, ProductInfo.class);
    }

    @GetMapping
    public List<ProductDto> findByShopName(@RequestParam String name){
        List<ShopEntity> shopEntities = shopService.findByNameLike(name);
        List<ProductDto> productDtos = new ArrayList<>();
        for(ShopEntity shopEntity : shopEntities) {
            for (ProductEntity product : shopEntity.getProducts()) {
                productDtos.add(
                    ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .shopId(shopEntity.getId())
                        .shopName(shopEntity.getName())
                    .build());
            }
        }
        return productDtos;
    }
}
