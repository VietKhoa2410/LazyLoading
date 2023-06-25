package com.example.lazyloading.model.shop.dto;


import com.example.lazyloading.model.employee.dto.CreateEmployeeRequest;
import com.example.lazyloading.model.product.dto.CreateProductRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class CreateShopRequest {
	private String name;
	private List<CreateProductRequest> products;
	private List<CreateEmployeeRequest> employees;
}


