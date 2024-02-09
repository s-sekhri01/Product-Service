package com.scaler.ProductService.Models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Category extends BaseModel {
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> products;
}
