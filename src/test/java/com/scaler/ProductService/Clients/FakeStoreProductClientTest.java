package com.scaler.ProductService.Clients;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.scaler.ProductService.Clients.FakeStoreProductClient;
import com.scaler.ProductService.Clients.DTOs.FakeStoreProductDTO;
import com.scaler.ProductService.Exceptions.NotFoundException;

public class FakeStoreProductClientTest {

    private FakeStoreProductClient fakeStoreProductClient;

    private RestTemplateBuilder restTemplateBuilder = Mockito.mock(RestTemplateBuilder.class);

    @Test
    public void testGetProductById() throws NotFoundException {
        RestTemplate restTemplate = Mockito.mock(RestTemplate.class);

        when(restTemplateBuilder.build())
                .thenReturn(restTemplate);

        ResponseEntity<FakeStoreProductDTO> responseEntity = new ResponseEntity<>(null, HttpStatus.OK);

        when(restTemplate.getForEntity(any(String.class), eq(FakeStoreProductDTO.class), any(Long.class)))
                .thenReturn(responseEntity);

        FakeStoreProductDTO response = fakeStoreProductClient.getProductById(1L);

        Assertions.assertNull(response);
    }
}
