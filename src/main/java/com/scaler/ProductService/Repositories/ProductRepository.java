package com.scaler.ProductService.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.ProductService.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product deleteByUuid(UUID uuid);
}
