package com.scaler.ecommerce.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.scaler.ecommerce.Exceptions.NotFoundException;
import com.scaler.ecommerce.Models.Category;
import com.scaler.ecommerce.Repositories.CategoryRepository;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(UUID uuid) throws NotFoundException{
        return categoryRepository.findById(uuid);
    }
}
