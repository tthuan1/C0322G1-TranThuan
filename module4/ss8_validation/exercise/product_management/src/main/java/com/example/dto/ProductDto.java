package com.example.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class ProductDto implements Validator {
    private Integer id;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^[a-z]$",message = "lỗi nhập sai")
    private String name;

@Min(1)
    private Double price;
    @NotEmpty
    @NotBlank
    @NotNull
    private String describeProduct;
    @NotEmpty
    @NotBlank
    @NotNull
    private String producer;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Double price, String describeProduct, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describeProduct = describeProduct;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
