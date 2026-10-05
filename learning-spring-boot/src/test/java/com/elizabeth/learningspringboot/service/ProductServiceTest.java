package com.elizabeth.learningspringboot.service;


import com.elizabeth.learningspringboot.dto.CreateProductRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.elizabeth.learningspringboot.repository.ProductRepository;
import com.elizabeth.learningspringboot.model.Product;
import com.elizabeth.learningspringboot.exception.ProductNotFoundException;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository; // Creación del mock

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldFindProductById() { // Definición de prueba

        Product product = new Product();
        product.setId(1L);
        product.setName("Laptop");
        product.setPrice(15000);

        when(productRepository.findById(1L))
                .thenReturn(product); // Configurar el mock

        Product result = productService.findById(1L); // Ejecutar el código que se quiere probar

        assertEquals(product, result); // Comprobar el resultado

        verify(productRepository).findById(1L);
    }

    @Test
    void shouldErrorProductById() {
        when(productRepository.findById(1L)).thenReturn(null);

        ProductNotFoundException exception = assertThrows(
                ProductNotFoundException.class,
                () -> {
                    productService.findById(1L);
                }
        );
        assertEquals("Producto no encontrado con el id 1", exception.getMessage());
    }

    @Test
    void shouldSaveProduct() {
        Product savedProduct = new Product();
        savedProduct.setId(2L);
        savedProduct.setName("Tablet");
        savedProduct.setPrice(500);

        when(productRepository.save(any(Product.class)))
                .thenReturn(savedProduct);

        CreateProductRequest product = new CreateProductRequest();
        product.setName("Tablet");
        product.setPrice(500);

        Product result = productService.createProduct(product);

        assertEquals(savedProduct, result);

        verify(productRepository).save(any(Product.class));
    }

    @Test
    void shouldDeleteProduct() {
        when(productRepository.deleteById(1L)).thenReturn(true);

        boolean isDeleted = productService.deleteById(1L);

        assertTrue(isDeleted);
        verify(productRepository).deleteById(1L);
    }

    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {
        when(productRepository.deleteById(1L)).thenReturn(false);

        ProductNotFoundException exception = assertThrows(
                ProductNotFoundException.class,
                () -> {
                    productService.deleteById(1L);
                }
        );
        assertEquals("Producto no encontrado para eliminar con el id 1", exception.getMessage());
    }
}