package com.elizabeth.learningspringboot.repository;

import java.util.List;
import java.util.ArrayList;
import com.elizabeth.learningspringboot.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository  implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}