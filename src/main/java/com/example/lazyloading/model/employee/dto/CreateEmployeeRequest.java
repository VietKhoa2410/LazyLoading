package com.example.lazyloading.model.employee.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
public class CreateEmployeeRequest {
    private Long shopId;
    private String name;
    private String address;
    private ZonedDateTime dob;
}
