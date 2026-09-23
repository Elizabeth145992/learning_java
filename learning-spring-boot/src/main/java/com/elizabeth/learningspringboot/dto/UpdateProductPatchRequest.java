package com.elizabeth.learningspringboot.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UpdateProductPatchRequest {

    @Size(min = 2, message = "El nombre debe tener más de 2 caracteres")
    private String name;

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