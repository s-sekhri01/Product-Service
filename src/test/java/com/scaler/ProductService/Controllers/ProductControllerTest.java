package com.scaler.ProductService.Controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.scaler.ProductService.Controllers.ProductController;
import com.scaler.ProductService.DTOs.ResponseProductDTO;
import com.scaler.ProductService.Exceptions.NotFoundException;
import com.scaler.ProductService.Services.InbuiltProductService;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private InbuiltProductService inbuiltProductService;

    @Test
    public void checkIfGetProductByIdReturnsNull() throws NotFoundException {
        when(inbuiltProductService.getProductById(any())).thenReturn(null);

        ResponseProductDTO response = productController.getProductById("eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkQXQiOjE3MDg5MjY3MjkyMTgsImV4cGlyeUF0IjoxOTc4MiwiZW1haWwiOiJ0aW5hc2hhcm1hQGdtYWlsLmNvbSJ9.lMg_D0tA50ae0y_l-j9cabBmCWf326x0LBuaT1FanxE ",
                "0bb3ad31-5eb1-44a1-a022-3f3b7530b1ca");

        Assertions.assertNull(response);
    }

    @Test
    public void testGetProductById2() throws NotFoundException {
        when(inbuiltProductService.getProductById(any())).thenReturn(null);

        ResponseProductDTO response = productController.getProductById(null,null);

        verify(inbuiltProductService, times(0)).getProductById(null);


    }

}
