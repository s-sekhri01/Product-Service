package com.scaler.ProductService.DTOs;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDTO {
    private HttpStatus httpStatus;
    private String message;

    public ExceptionDTO(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
