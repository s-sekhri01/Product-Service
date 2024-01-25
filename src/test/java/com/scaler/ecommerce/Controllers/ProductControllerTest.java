package com.scaler.ecommerce.Controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.scaler.ecommerce.Models.Product;
import com.scaler.ecommerce.Services.InbuiltProductService;

@SpringBootTest
public class ProductControllerTest {
    
    @Autowired
    private ProductController productController;

    @MockBean
    private InbuiltProductService inbuiltProductService;

    @Test
    public void checkIfGetProductByIdReturnsNull (){
        when(inbuiltProductService.getProductById(any()))
            .thenReturn(null);
        
        // Product response = productController.getProductById();
    }


}
