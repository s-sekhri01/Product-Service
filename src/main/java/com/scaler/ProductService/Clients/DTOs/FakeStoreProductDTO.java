package com.scaler.ProductService.Clients.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
    public Object getBody() {
        return null;
    }
}
