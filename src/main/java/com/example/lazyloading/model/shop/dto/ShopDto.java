package com.example.lazyloading.model.shop.dto;

import com.example.lazyloading.model.product.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShopDto {
    private Long id;
    private String name;
//    private List<ProductDto> products;
}
