package com.scaler.ecommerce.Controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.scaler.ecommerce.DTOs.ResponseProductDTO;
import com.scaler.ecommerce.Services.InbuiltProductService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerMockMCVTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private InbuiltProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetProductById() throws Exception {
        ResponseProductDTO responseProductDTO = new ResponseProductDTO();
        responseProductDTO.setId("32098ruefiwfhdknsdkjfhsdi");
        responseProductDTO.setTitle("iPhone");
        responseProductDTO.setCategory("test");

        when(productService.getProductById("32098ruefiwfhdknsdkjfhsdi"))
                .thenReturn(responseProductDTO);

        mockMvc.perform(get("/products/32098ruefiwfhdknsdkjfhsdi"))
                .andExpect(status().is(200));
    }
}
