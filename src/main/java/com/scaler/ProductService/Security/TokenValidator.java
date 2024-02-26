package com.scaler.ProductService.Security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TokenValidator {
    private RestTemplateBuilder restTemplateBuilder;
    public TokenValidator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public Optional<JwtData> validateToken(String Token){
        // Use Rest template to make call to user Service.
        return Optional.empty();
    }
}
