package com.example.lazyloading.model.shop.entity;

import com.example.lazyloading.model.product.entity.ProductEntity;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ShopEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	@CreatedDate
	private ZonedDateTime createdAt;

//	@Builder.Default
	@OneToMany(mappedBy = ProductEntity.Fields.shop, fetch = FetchType.LAZY)
	private List<ProductEntity> products ;

	public void addProduct(ProductEntity product){
		if(Objects.isNull(products))
			products = new ArrayList<>();
		products.add(product);
		product.setShop(this);
	}
}
