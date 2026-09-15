package com.elizabeth.learningspringboot.repository;

import java.util.List;
import com.elizabeth.learningspringboot.model.Product;

public interface ProductRepository {

    Product save(Product product);
    List<Product> findAll();
}