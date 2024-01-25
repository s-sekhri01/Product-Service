package com.scaler.ecommerce.Services;

import java.util.List;

import com.scaler.ecommerce.DTOs.GenericProductDTO;
import com.scaler.ecommerce.Exceptions.NotFoundException;

public interface OutSourceProductService {
    public GenericProductDTO getProductById(Long id) throws NotFoundException;

    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

    public List<GenericProductDTO> getAllProducts();

    public GenericProductDTO deleteProduct(Long id);

    public GenericProductDTO updateProduct(Long id, GenericProductDTO genericProductDTO) throws NotFoundException;
}
