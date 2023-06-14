package com.example.lazyloading.model.shop.service;

import com.example.lazyloading.model.product.dto.CreateProductRequest;
import com.example.lazyloading.model.product.entity.ProductEntity;
import com.example.lazyloading.model.shop.dto.CreateShopRequest;
import com.example.lazyloading.model.shop.entity.ShopEntity;
import com.example.lazyloading.model.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {
	private final ShopRepository shopRepository;

	public void create(CreateShopRequest createShopRequest){
		ShopEntity shopEntity = ShopEntity.builder()
			.name(createShopRequest.getName())
			.build();
		List<ProductEntity> productEntities = new ArrayList<>();
		for (CreateProductRequest createProductRequest : createShopRequest.getProducts()){
			productEntities.add(
				ProductEntity.builder()
					.name(createProductRequest.getName())
					.build()
			);
		}
		shopEntity.setProducts(productEntities);
		shopRepository.save(shopEntity);
	}
}
