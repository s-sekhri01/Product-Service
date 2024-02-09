package com.scaler.ProductService.Controllers;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.ProductService.Controllers.ProductController;
import com.scaler.ProductService.DTOs.ResponseProductDTO;
import com.scaler.ProductService.Services.InbuiltProductService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @SpringBootTest
// @AutoConfigureMockMvc
@WebMvcTest(ProductController.class)
public class ProductControllerMockMCVTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private InbuiltProductService productService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetProductById() throws Exception {
        ResponseProductDTO responseProductDTO = new ResponseProductDTO();
        responseProductDTO.setId("32098ruefiwfhdknsdkjfhsdi");
        responseProductDTO.setTitle("iPhone");
        responseProductDTO.setCategory("test");

        when(productService.getProductById("32098ruefiwfhdknsdkjfhsdi"))
                .thenReturn(responseProductDTO);

        ResultActions resultActions = mockMvc.perform(get("/products/32098ruefiwfhdknsdkjfhsdi"))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(responseProductDTO)))
                .andExpect(jsonPath("$.id").value("32098ruefiwfhdknsdkjfhsdi"));

        String responseString = resultActions.andReturn().getResponse().getContentAsString();

        // System.out.println(responseString);

        // Assertions.assertEquals(
        //         "{\\\"id\\\":"32098ruefiwfhdknsdkjfhsdi",\\\"title\\\":\\\"iPhone\\\",\\\"description\\\":null,\\\"image\\\":null,\\\"category\\\":\\\"test\\\",\\\"price\\\":0.0}",
        //         responseString);

        ResponseProductDTO responseDTO = objectMapper.readValue(responseString, ResponseProductDTO.class);

        Assertions.assertNotNull(responseDTO);
        Assertions.assertEquals("32098ruefiwfhdknsdkjfhsdi", responseDTO.getId());
    }
}
