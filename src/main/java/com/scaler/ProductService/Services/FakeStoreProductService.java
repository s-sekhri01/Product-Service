package com.scaler.ProductService.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.scaler.ProductService.Clients.FakeStoreProductClient;
import com.scaler.ProductService.Clients.DTOs.FakeStoreProductDTO;
import com.scaler.ProductService.DTOs.RequestProductDTO;
import com.scaler.ProductService.DTOs.ResponseProductDTO;
import com.scaler.ProductService.Exceptions.NotFoundException;

@Primary
@Service()
public class FakeStoreProductService implements ProductService {

    private FakeStoreProductClient fakeStoreProductClient;

    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient) {
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    // Map the response objec to our genericProduct DTO (usually done in Mapper
    // classes)

    public static FakeStoreProductDTO requestProductDTOMapper(RequestProductDTO requestProductDTO) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(requestProductDTO.getTitle());
        fakeStoreProductDTO.setDescription(requestProductDTO.getDescription());
        fakeStoreProductDTO.setImage(requestProductDTO.getImage());
        fakeStoreProductDTO.setCategory(requestProductDTO.getCategory());
        fakeStoreProductDTO.setPrice(requestProductDTO.getPrice());

        return fakeStoreProductDTO;
    }

    public static ResponseProductDTO responseProductDTOMapper(FakeStoreProductDTO fakeStoreProductDTO) {
        ResponseProductDTO responseProductDTO = new ResponseProductDTO();
        responseProductDTO.setId(String.valueOf(fakeStoreProductDTO.getId()));
        responseProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        responseProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        responseProductDTO.setImage(fakeStoreProductDTO.getImage());
        responseProductDTO.setCategory(fakeStoreProductDTO.getCategory());
        responseProductDTO.setPrice(fakeStoreProductDTO.getPrice());

        return responseProductDTO;
    }

    public ResponseProductDTO getProductById(String id) throws NotFoundException {
        Long longId = Long.parseLong(id);
        return responseProductDTOMapper(fakeStoreProductClient.getProductById(longId));
    }

    public ResponseProductDTO createProduct(RequestProductDTO requestProductDTO) {
        return responseProductDTOMapper(fakeStoreProductClient.createProduct(requestProductDTO));
    }

    public List<ResponseProductDTO> getAllProducts() {
        List<FakeStoreProductDTO> fakeStoreProductDTOList = fakeStoreProductClient.getAllProducts();

        List<ResponseProductDTO> responseProductDTOList = new ArrayList<>();

        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList) {
            responseProductDTOList.add(responseProductDTOMapper(fakeStoreProductDTO));
        }

        return responseProductDTOList;
    }

    public ResponseProductDTO deleteProduct(String id) {
        Long longId = Long.parseLong(id);
        return responseProductDTOMapper(fakeStoreProductClient.deleteProduct(longId));
    }

    public ResponseProductDTO updateProduct(String id, RequestProductDTO requestProductDTO) throws NotFoundException {
        return responseProductDTOMapper(
                fakeStoreProductClient.updateProductById(Long.parseLong(id), requestProductDTO));
    }
}
