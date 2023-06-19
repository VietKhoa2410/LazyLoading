package com.example.lazyloading.model.shop.service;

import com.example.lazyloading.model.product.dto.CreateProductRequest;
import com.example.lazyloading.model.product.entity.ProductEntity;
import com.example.lazyloading.model.shop.dto.CreateShopRequest;
import com.example.lazyloading.model.shop.dto.ShopInfo;
import com.example.lazyloading.model.shop.entity.ShopEntity;
import com.example.lazyloading.model.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class ShopService {
	private final ShopRepository shopRepository;

	public void create(CreateShopRequest createShopRequest){
		ShopEntity shopEntity = ShopEntity.builder()
			.name(createShopRequest.getName())
			.build();

		for (CreateProductRequest createProductRequest : createShopRequest.getProducts()){
			shopEntity.addProduct(
				ProductEntity.builder()
					.name(createProductRequest.getName())
					.build()
			);
		}
		shopRepository.save(shopEntity);
	}

	public ShopEntity findById(Long id) throws EntityNotFoundException {
		return shopRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	public ShopInfo findInfoById(Long id) throws EntityNotFoundException {
		return shopRepository.findInfoById(id);
	}
}
