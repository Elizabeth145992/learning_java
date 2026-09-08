package com.elizabeth.learningspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hola Spring Boot!";
    }

    @GetMapping("/saludo/{nombre}")
    public String saludoPersonalizado(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @GetMapping("/curso")
    public String curso() {
        return "Estoy aprendiendo Spring Boot";
    }

    @GetMapping("/bienvenida")
    public String bienvenida(@RequestParam String nombre) {
        return "Bienvenida " + nombre;
    }
}