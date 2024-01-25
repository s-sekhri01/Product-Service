package com.scaler.ecommerce.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.ecommerce.Exceptions.NotFoundException;
import com.scaler.ecommerce.Models.Category;
import com.scaler.ecommerce.Services.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    
    @GetMapping("uuid")
    public Category getMethodName(@PathVariable("uuid") UUID uuid) throws NotFoundException {
        Optional<Category> opt = categoryService.getCategoryById(uuid);
        if(!opt.isPresent()){
            throw new NotFoundException("Category with id : "+uuid.toString()+" not found.");
        }
        return opt.get();
    }
    

}