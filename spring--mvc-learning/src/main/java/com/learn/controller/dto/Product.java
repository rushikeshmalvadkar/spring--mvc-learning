package com.learn.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {

    private String name;

    private BigDecimal price;

    private Boolean isPrimeProduct;

    private String category;

}
