package com.example.lazyloading.model.product.service;

import com.example.lazyloading.model.product.dto.ProductDto;
import com.example.lazyloading.model.product.dto.ProductInfo;
import com.example.lazyloading.model.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public <T> T findById(Long id, Class<T> tClass){
        return productRepository.findById(id, tClass);
    }

    public List<ProductDto> findProductDtoByNameLike(String name){
        return productRepository.findProductDtoByNameLike(name);
    }

    public List<ProductInfo> findProductInfoByNameLike(String name){
        return productRepository.findByShopNameContaining(name);
    }
}
