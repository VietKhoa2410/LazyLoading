package com.example.lazyloading.controller;

import com.example.lazyloading.model.product.dto.ProductInfo;
import com.example.lazyloading.model.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("{id}")
    public String findNameById(@PathVariable Long id){
        return productService.findById(id).getName();
    }

    @GetMapping("{id}/info")
    public ProductInfo findInfoById(@PathVariable Long id){
        return productService.findById(id, ProductInfo.class);
    }
}
