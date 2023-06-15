package com.example.lazyloading.model.shop.service;

import com.example.lazyloading.model.product.dto.CreateProductRequest;
import com.example.lazyloading.model.product.entity.ProductEntity;
import com.example.lazyloading.model.shop.dto.CreateShopRequest;
import com.example.lazyloading.model.shop.entity.ShopEntity;
import com.example.lazyloading.model.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


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

	public ShopEntity findById(Long id) throws NotFoundException {
		return shopRepository.findById(id).orElse(null);
	}
}
