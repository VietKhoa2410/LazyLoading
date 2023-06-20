package com.example.lazyloading.model.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String shopName;
    private Long shopId;
}
