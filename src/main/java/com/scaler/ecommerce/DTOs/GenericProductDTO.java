package com.scaler.ecommerce.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDTO {
    private Long id;
    private String title;
    private String Description;
    private String image;
    private String category;
    private double price;
}
