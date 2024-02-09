package com.scaler.ProductService.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.ProductService.Models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    Category findByName(String name);

}
