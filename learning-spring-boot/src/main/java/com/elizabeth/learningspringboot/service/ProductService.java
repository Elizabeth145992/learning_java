package com.elizabeth.learningspringboot.service;

import java.util.List;

import com.elizabeth.learningspringboot.dto.CreateProductRequest;
import com.elizabeth.learningspringboot.dto.UpdateProductRequest;
import com.elizabeth.learningspringboot.dto.UpdateProductPatchRequest;
import com.elizabeth.learningspringboot.model.Product;
import org.springframework.stereotype.Service;
import com.elizabeth.learningspringboot.repository.ProductRepository;
import com.elizabeth.learningspringboot.exception.ProductNotFoundException;

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

    public Product updateById(UpdateProductRequest request, Long id) {
        Product product = new Product();

        product.setId(id);
        product.setName(request.getName());
        product.setPrice(request.getPrice());

        boolean updated = productRepository.updateProduct(product);

        if (!updated) {
            throw new ProductNotFoundException(
                    "Producto no encontrado para actualizar con el id " + id
            );
        }

        return product;
    }

    public Product updateProductPatch(UpdateProductPatchRequest request, Long id) {
        Product product = productRepository.findById(id);

        if (product == null) {
            throw new ProductNotFoundException("Producto no encontrado con el id " + id);
        }

        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }

        productRepository.updateProduct(product);

        return product;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Product product = productRepository.findById(id);
        if(product == null) {
            throw new ProductNotFoundException("Producto no encontrado con el id " + id);
        }
        return  product;
    }

    public boolean deleteById(Long id) {
        boolean deletedProduct = productRepository.deleteById(id);

        if(!deletedProduct) {
            throw  new ProductNotFoundException("Producto no encontrado para eliminar con el id " + id);
        }
        return true;
    }
}