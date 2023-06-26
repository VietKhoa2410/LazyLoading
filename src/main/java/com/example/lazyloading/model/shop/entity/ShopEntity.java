package com.example.lazyloading.model.shop.entity;

import com.example.lazyloading.model.product.entity.ProductEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldNameConstants
@EntityListeners(AuditingEntityListener.class)
@NamedEntityGraph(name = "Shop.products",
	attributeNodes = @NamedAttributeNode("products")
)
public class ShopEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	@CreatedDate
	private LocalDateTime createdAt;

	@Builder.Default
	@OneToMany(mappedBy = ProductEntity.Fields.shop, orphanRemoval = true,
		cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductEntity> products = new ArrayList<>();

	public void addProduct(ProductEntity product){
		products.add(product);
		product.setShop(this);
	}
}
