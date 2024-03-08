package com.scaler.ProductService.Services;

import com.scaler.ProductService.DTOs.ResponseProductDTO;
import com.scaler.ProductService.Models.Product;
import com.scaler.ProductService.Repositories.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ResponseProductDTO> search(String query, int pageNumber, int pageSize) {
        Sort sort = Sort.by("title").ascending()
                .and(Sort.by("price").descending());
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Product> productPage = productRepository.findAllByTitleContaining(query, pageable);
        List<Product> productList = productPage.get().toList();
        List<ResponseProductDTO> responseList = new ArrayList<>();
        for (Product product : productList) {
            responseList.add(mapProductToGenericProduct(product));
        }
        Page<ResponseProductDTO> responsePage =
                new PageImpl<ResponseProductDTO>(responseList
                        , pageable
                        , productPage.getTotalElements());
        return responsePage;
    }

    public ResponseProductDTO mapProductToGenericProduct(Product product) {
        ResponseProductDTO genericProductDto = new ResponseProductDTO();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setDescription(product.getDescription());

        return genericProductDto;
    }
}