package com.elizabeth.learningspringboot.controller;

import java.util.List;

import com.elizabeth.learningspringboot.dto.CreateProductRequest;
import com.elizabeth.learningspringboot.dto.CreateUserRequest;
import com.elizabeth.learningspringboot.dto.UpdateProductRequest;
import com.elizabeth.learningspringboot.dto.UpdateProductPatchRequest;
import com.elizabeth.learningspringboot.model.Product;
import com.elizabeth.learningspringboot.service.ProductService;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/products/{id}")
    public Product updateProductById(
            @Valid @RequestBody UpdateProductRequest request, @PathVariable Long id
    ) {
        return  productService.updateById(request, id);
    }

    @PatchMapping("/products/{id}")
    public  Product updateProductPatch(
       @Valid @RequestBody UpdateProductPatchRequest request, @PathVariable Long id
    ) {
        return productService.updateProductPatch(request, id);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product findById(
            @PathVariable Long id
    ) {
        return  productService.findById(id);
    }

    @DeleteMapping("/products/{id}")
    public boolean deleteById(
            @PathVariable Long id
    ) {
        return  productService.deleteById(id);
    }
}