package com.scaler.ecommerce.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.ecommerce.Models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
