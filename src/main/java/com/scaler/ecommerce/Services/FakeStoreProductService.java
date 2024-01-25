package com.scaler.ecommerce.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.scaler.ecommerce.Clients.FakeStoreProductClient;
import com.scaler.ecommerce.Clients.DTOs.FakeStoreProductDTO;
import com.scaler.ecommerce.DTOs.GenericProductDTO;
import com.scaler.ecommerce.Exceptions.NotFoundException;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements OutSourceProductService {

    private FakeStoreProductClient fakeStoreProductClient;

    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient) {
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    // Map the response objec to our genericProduct DTO (usually done in Mapper
    // classes)
    private GenericProductDTO productDTOmapper(FakeStoreProductDTO fakeStoreProductDTO) {
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDTO.getId());
        genericProductDTO.setTitle(fakeStoreProductDTO.getTitle());
        genericProductDTO.setDescription(fakeStoreProductDTO.getDescription());
        genericProductDTO.setImage(fakeStoreProductDTO.getImage());
        genericProductDTO.setPrice(fakeStoreProductDTO.getPrice());
        genericProductDTO.setCategory(fakeStoreProductDTO.getCategory());

        return genericProductDTO;
    }

    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {
        return productDTOmapper(fakeStoreProductClient.getProductById(id));
    }

    // Create another mapper to convert genericProductDTO to FakeStoreProductDTO
    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        return productDTOmapper(fakeStoreProductClient.createProduct(genericProductDTO));
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<FakeStoreProductDTO> fakeStoreProductDTOList = fakeStoreProductClient.getAllProducts();

        List<GenericProductDTO> genericProductDTOList = new ArrayList<>();
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList) {
            genericProductDTOList.add(productDTOmapper(fakeStoreProductDTO));
        }

        return genericProductDTOList;
    }

    @Override
    public GenericProductDTO deleteProduct(Long id) {
        return productDTOmapper(fakeStoreProductClient.deleteProduct(id));
    }

    @Override
    public GenericProductDTO updateProduct(Long id, GenericProductDTO genericProductDTO) throws NotFoundException {
        // TODO Auto-generated method stub
        return productDTOmapper(fakeStoreProductClient.updateProductById(id, genericProductDTO));
    }
}
