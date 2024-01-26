package com.scaler.ecommerce.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.scaler.ecommerce.DTOs.RequestProductDTO;
import com.scaler.ecommerce.DTOs.ResponseProductDTO;
import com.scaler.ecommerce.Exceptions.NotFoundException;
import com.scaler.ecommerce.Models.Category;
import com.scaler.ecommerce.Models.Currency;
import com.scaler.ecommerce.Models.Price;
import com.scaler.ecommerce.Models.Product;
import com.scaler.ecommerce.Repositories.CategoryRepository;
import com.scaler.ecommerce.Repositories.ProductRepository;

@Service
public class InbuiltProductService {

    private ProductRepository productRepository;

    private static CategoryRepository categoryRepository;

    public InbuiltProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        InbuiltProductService.categoryRepository = categoryRepository;
    }

    public List<ResponseProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ResponseProductDTO> response = new ArrayList<>();
        for (Product product : products) {
            response.add(responseProductDTOMapper(product));
        }
        return response;
    }

    public ResponseProductDTO getProductById(String id) throws NotFoundException {
        UUID uuid = UUID.fromString(id);
        if (uuid == null)
            throw new NullPointerException();
        Optional<Product> product = productRepository.findById(uuid);
        ResponseProductDTO response = new ResponseProductDTO();
        if (product.isPresent()) {
            response = responseProductDTOMapper(product.get());
        } else {
            throw new NotFoundException("Product with id : " + id + " is not found.");
        }
        return response;
    }

    public ResponseProductDTO createOrUpdateProduct(RequestProductDTO requestProductDTO) {
        Product product = requestProductDTOMapper(requestProductDTO);
        return responseProductDTOMapper(productRepository.save(product));
    }

    public void deleteProduct(String id) {
        UUID uuid = UUID.fromString(id);
        if (uuid == null)
            throw new NullPointerException();
        productRepository.deleteById(uuid);
    }

    public static Product requestProductDTOMapper(RequestProductDTO requestProductDTO) {
        Product product = new Product();
        product.setTitle(requestProductDTO.getTitle());
        product.setDescription(requestProductDTO.getDescription());
        product.setImage(requestProductDTO.getImage());
        Category category;
        if (categoryRepository.findByName(requestProductDTO.getCategory()) != null) {
            category = categoryRepository.findByName(requestProductDTO.getCategory());
        } else {
            category = new Category();
            category.setName(requestProductDTO.getCategory());
        }
        product.setCategory(category);
        Price price = new Price();
        price.setAmount(requestProductDTO.getPrice());
        price.setCurrency(Currency.valueOf(requestProductDTO.getCurrency()));
        product.setPrice(price);

        return product;
    }

    public static ResponseProductDTO responseProductDTOMapper(Product product) {
        ResponseProductDTO responseProductDTO = new ResponseProductDTO();
        responseProductDTO.setId(product.getUuid().toString());
        responseProductDTO.setTitle(product.getTitle());
        responseProductDTO.setDescription(product.getDescription());
        responseProductDTO.setImage(product.getImage());
        responseProductDTO.setCategory(product.getCategory().getName());
        responseProductDTO.setPrice(product.getPrice().getAmount());
        responseProductDTO.setCurrency(product.getPrice().getCurrency().toString());

        return responseProductDTO;
    }

}
