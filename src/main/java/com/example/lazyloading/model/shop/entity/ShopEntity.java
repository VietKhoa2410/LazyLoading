package com.example.lazyloading.model.shop.entity;

import com.example.lazyloading.model.product.entity.ProductEntity;
import java.util.ArrayList;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ShopEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	@Builder.Default
	@OneToMany(mappedBy = ProductEntity.Fields.shop,orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductEntity> products = new ArrayList<>();

	public void addProduct(ProductEntity product){
		products.add(product);
		product.setShop(this);
	}
}
