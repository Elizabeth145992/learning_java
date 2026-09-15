package com.elizabeth.learningspringboot.service;

import java.util.List;

import com.elizabeth.learningspringboot.dto.CreateProductRequest;
import com.elizabeth.learningspringboot.model.Product;
import org.springframework.stereotype.Service;
import com.elizabeth.learningspringboot.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(CreateProductRequest request) {

        Product product = new Product();

        product.setName(request.getName());
        product.setPrice(request.getPrice());

        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}