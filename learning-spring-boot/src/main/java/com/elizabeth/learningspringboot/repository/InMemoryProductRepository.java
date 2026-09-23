package com.elizabeth.learningspringboot.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.elizabeth.learningspringboot.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository  implements ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Product save(Product product) {
        product.setId(nextId);
        products.add(product);
        nextId++;
        return product;
    }

    @Override
    public boolean updateById(Product product) {
        Product existingProduct = findById(product.getId());

        if (existingProduct == null) {
            return false;
        }

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());

        return true;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(Long id) {
        for (Product product: products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();

            if (product.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}