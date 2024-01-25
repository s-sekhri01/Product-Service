package com.scaler.ecommerce.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.ecommerce.DTOs.ResponseCategoryDTO;
import com.scaler.ecommerce.Exceptions.NotFoundException;
import com.scaler.ecommerce.Services.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<ResponseCategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public ResponseCategoryDTO getCategoryById(@PathVariable("id") String id) throws NotFoundException {
        return categoryService.getCategoryById(id);
    }

}