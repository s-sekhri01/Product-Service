package com.scaler.ProductService.DTOs;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCategoryDTO {
    private String id;
    private String name;
    private List<ResponseProductDTO> productsList;
}
