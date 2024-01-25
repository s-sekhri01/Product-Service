package com.scaler.ecommerce.Controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.scaler.ecommerce.DTOs.ResponseProductDTO;
import com.scaler.ecommerce.Exceptions.NotFoundException;
import com.scaler.ecommerce.Services.InbuiltProductService;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private InbuiltProductService inbuiltProductService;

    @Test
    public void checkIfGetProductByIdReturnsNull() throws NotFoundException {
        when(inbuiltProductService.getProductById(any()))
                .thenReturn(null);

        ResponseProductDTO response = productController.getProductById("0bb3ad31-5eb1-44a1-a022-3f3b7530b1ca");

        Assertions.assertNull(response);
    }

}
