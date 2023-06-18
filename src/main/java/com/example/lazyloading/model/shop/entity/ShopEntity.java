package com.example.lazyloading.model.shop.entity;

import com.example.lazyloading.model.product.entity.ProductEntity;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ShopEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	@Builder.Default
//	@JsonIgnore
//	@JsonBackReference
	@OneToMany(mappedBy = "shop",
		orphanRemoval = true, cascade = CascadeType.ALL,
		fetch = FetchType.LAZY)
	private List<ProductEntity> products = new ArrayList<>();

	public void addProduct(ProductEntity product){
		products.add(product);
		product.setShop(this);
	}
}
