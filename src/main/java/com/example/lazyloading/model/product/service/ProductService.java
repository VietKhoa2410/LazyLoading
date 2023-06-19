package com.example.lazyloading.model.product.service;

import com.example.lazyloading.model.product.entity.ProductEntity;
import com.example.lazyloading.model.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductEntity findById(Long id){
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public <T> T findById(Long id, Class<T> tClass){
        return productRepository.findById(id, tClass);
    }
}
