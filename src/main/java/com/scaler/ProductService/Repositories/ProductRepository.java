package com.scaler.ProductService.Repositories;

import com.scaler.ProductService.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    Product deleteByUuid(UUID uuid);

    Page<Product> findAllByTitle(String title, Pageable pageable);
    Page<Product> findAllByTitleContaining(String title, Pageable pageable);
}
