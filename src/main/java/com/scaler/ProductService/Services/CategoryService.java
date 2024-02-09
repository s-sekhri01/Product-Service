package com.scaler.ProductService.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.scaler.ProductService.DTOs.RequestCategoryDTO;
import com.scaler.ProductService.DTOs.ResponseCategoryDTO;
import com.scaler.ProductService.DTOs.ResponseProductDTO;
import com.scaler.ProductService.Exceptions.NotFoundException;
import com.scaler.ProductService.Models.Category;
import com.scaler.ProductService.Repositories.CategoryRepository;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<ResponseCategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<ResponseCategoryDTO> response = new ArrayList<>();
        for (Category category : categories) {
            response.add(responseCategoryDTOMapper(category));
        }
        return response;
    }

    public ResponseCategoryDTO getCategoryById(String id) throws NotFoundException {
        UUID uuid = UUID.fromString(id);
        if (uuid == null)
            throw new NullPointerException();
        Optional<Category> optCategory = categoryRepository.findById(uuid);
        if (!optCategory.isPresent())
            throw new NotFoundException("Category with id : " + id + " not found.");
        return responseCategoryDTOMapper(optCategory.get());
    }

    public ResponseCategoryDTO getCategoryByName(String name){
        return responseCategoryDTOMapper(categoryRepository.findByName(name));
    }

    public static Category requestCategoryDTOMapper(RequestCategoryDTO requestCategoryDTO) {
        Category category = new Category();
        category.setName(requestCategoryDTO.getName());

        return category;
    }

    public static ResponseCategoryDTO responseCategoryDTOMapper(Category category) {
        ResponseCategoryDTO responseCategoryDTO = new ResponseCategoryDTO();
        responseCategoryDTO.setId(category.getUuid().toString());
        responseCategoryDTO.setName(category.getName());

        List<ResponseProductDTO> productsList = category.getProducts().stream()
                .map(InbuiltProductService::responseProductDTOMapper)
                .collect(Collectors.toList());

        responseCategoryDTO.setProductsList(productsList);

        return responseCategoryDTO;
    }
}
