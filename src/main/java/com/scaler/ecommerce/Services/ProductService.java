package com.scaler.ecommerce.Services;

import java.util.List;

import com.scaler.ecommerce.DTOs.RequestProductDTO;
import com.scaler.ecommerce.DTOs.ResponseProductDTO;
import com.scaler.ecommerce.Exceptions.NotFoundException;

public interface ProductService {
    public ResponseProductDTO getProductById(String id) throws NotFoundException;

    public ResponseProductDTO createProduct(RequestProductDTO requestProductDTO);

    public List<ResponseProductDTO> getAllProducts();

    public ResponseProductDTO deleteProduct(String id);

    public ResponseProductDTO updateProduct(String id, RequestProductDTO requestProductDTO) throws NotFoundException;
}
