package com.elizabeth.learningspringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

public class UpdateProductRequest {
    @NotBlank(message = "El nombre del producto es obligatiorio")
    private String name;

    @NotNull(message = "El precio del producto es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}