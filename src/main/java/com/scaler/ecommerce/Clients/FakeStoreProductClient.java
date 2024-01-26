package com.scaler.ecommerce.Clients;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.scaler.ecommerce.Clients.DTOs.FakeStoreProductDTO;
import com.scaler.ecommerce.DTOs.RequestProductDTO;
import com.scaler.ecommerce.Exceptions.NotFoundException;

@Component
public class FakeStoreProductClient {

    @Value("${fakestore.api.baseurl}")
    private String baseUrl;
    @Value("${fakestore.api.product}")
    private String product;

    private String productsWithId;
    private String products;

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder,
            @Value("${fakestore.api.baseurl}") String baseUrl,
            @Value("${fakestore.api.product}") String product) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productsWithId = baseUrl + product + "/{id}";
        this.products = baseUrl + product;
    }

    public FakeStoreProductDTO getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(productsWithId,
                FakeStoreProductDTO.class,
                id);

        if (response.getBody() == null) {
            throw new NotFoundException("Product with id: " + id + " not found.");
        }

        return response.getBody();
    }

    public FakeStoreProductDTO createProduct(RequestProductDTO RequestProductDTO) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.postForEntity(products, RequestProductDTO,
                FakeStoreProductDTO.class);

        return response.getBody();
    }

    public List<FakeStoreProductDTO> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> response = restTemplate.getForEntity(products,
                FakeStoreProductDTO[].class);
        // ParameterizedTypeReference<List<FakeStoreProductDTO>>
        FakeStoreProductDTO[] fakeStoreProductDTOList = response.getBody();

        return Arrays.asList(fakeStoreProductDTOList);
    }

    public FakeStoreProductDTO deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.exchange(productsWithId,
                HttpMethod.DELETE, null, FakeStoreProductDTO.class, id);

        return response.getBody();
    }

    public FakeStoreProductDTO updateProductById(Long id, RequestProductDTO RequestProductDTO) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpEntity<RequestProductDTO> requestUpdate = new HttpEntity<>(RequestProductDTO);

        ResponseEntity<FakeStoreProductDTO> response = restTemplate.exchange(productsWithId,
                HttpMethod.PUT, requestUpdate, FakeStoreProductDTO.class, id );

        if (response.getBody() == null) {
            throw new NotFoundException("Product with id: " + id + " not found.");
        }

        return response.getBody();

    }
}
