package com.scaler.ecommerce.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.scaler.ecommerce.Exceptions.NotFoundException;
import com.scaler.ecommerce.Models.Product;
import com.scaler.ecommerce.Repositories.ProductRepository;

@Primary
@Service
public class InbuiltProductService {

    private ProductRepository productRepository;

    public InbuiltProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(UUID uuid) {
        return productRepository.findById(uuid);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(UUID uuid) {
        productRepository.deleteById(uuid);
    }

    public Product updateProduct(Product product) {
        // return productRepository.saveOrUpdate(product);
        return productRepository.save(product);
    }

}
