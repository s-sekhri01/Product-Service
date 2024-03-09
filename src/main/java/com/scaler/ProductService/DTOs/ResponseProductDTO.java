package com.scaler.ProductService.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseProductDTO implements Serializable {
    private String id;
    private String title;
    private String Description;
    private String image;
    private String category;
    private double price;
    private String currency;
}
