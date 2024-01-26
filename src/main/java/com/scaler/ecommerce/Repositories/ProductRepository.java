package com.scaler.ecommerce.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.ecommerce.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product deleteByUuid(UUID uuid);
}
