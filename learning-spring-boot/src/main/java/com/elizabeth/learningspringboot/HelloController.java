package com.elizabeth.learningspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
public class HelloController {

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
    public  CreateProductRequest createProduct(
            @Valid @RequestBody CreateProductRequest request
    ) {
        return request;
    }
}