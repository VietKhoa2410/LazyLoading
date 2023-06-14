package com.example.lazyloading.model.shop.entity;

import com.example.lazyloading.model.product.entity.ProductEntity;
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

	private String name;

	@OneToMany(mappedBy = ProductEntity.Fields.shop, fetch = FetchType.LAZY)
	private List<ProductEntity> products;
}
