package com.elizabeth.learningspringboot.controller;

import java.util.List;

import com.elizabeth.learningspringboot.dto.CreateProductRequest;
import com.elizabeth.learningspringboot.dto.CreateUserRequest;
import com.elizabeth.learningspringboot.model.Product;
import com.elizabeth.learningspringboot.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
public class HelloController {
    private final ProductService productService;

    public HelloController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/curso")
    public String curso() {
        return "Estoy aprendiendo Spring Boot";
    }

    @GetMapping("/saludo/{nombre}")
    public String saludoPersonalizado(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @GetMapping("/bienvenida")
    public String bienvenida(@RequestParam String nombre) {
        return "Bienvenida " + nombre;
    }

    @GetMapping("/usuario")
    public String usuario(
            @RequestParam String nombre,
            @RequestParam int edad
    ) {
        return "Hola " + nombre + ", tienes " + edad + " años";
    }

    @PostMapping("/users")
    public CreateUserRequest createUser(
            @Valid @RequestBody CreateUserRequest request
    ) {
        return request;
    }

    @PostMapping("/products")
    public Product createProduct(
            @Valid @RequestBody CreateProductRequest request
    ) {
        return productService.createProduct(request);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }
}