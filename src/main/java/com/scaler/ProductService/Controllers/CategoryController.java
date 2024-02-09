package com.scaler.ProductService.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.ProductService.DTOs.ResponseCategoryDTO;
import com.scaler.ProductService.Exceptions.NotFoundException;
import com.scaler.ProductService.Services.CategoryService;

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