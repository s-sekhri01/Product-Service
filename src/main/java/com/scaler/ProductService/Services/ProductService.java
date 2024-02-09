package com.scaler.ProductService.Services;

import java.util.List;

import com.scaler.ProductService.DTOs.RequestProductDTO;
import com.scaler.ProductService.DTOs.ResponseProductDTO;
import com.scaler.ProductService.Exceptions.NotFoundException;

public interface ProductService {
    public ResponseProductDTO getProductById(String id) throws NotFoundException;

    public ResponseProductDTO createProduct(RequestProductDTO requestProductDTO);

    public List<ResponseProductDTO> getAllProducts();

    public ResponseProductDTO deleteProduct(String id);

    public ResponseProductDTO updateProduct(String id, RequestProductDTO requestProductDTO) throws NotFoundException;
}
