package com.scaler.ecommerce.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String title;
    private String Description;
    private String image;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Price price;
}
