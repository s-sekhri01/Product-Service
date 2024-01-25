package com.scaler.ecommerce.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Price extends BaseModel{
    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private Currency currency;
}
