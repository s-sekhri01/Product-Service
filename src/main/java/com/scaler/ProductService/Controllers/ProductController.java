package com.scaler.ProductService.Controllers;

import java.util.List;
import java.util.Optional;

import com.scaler.ProductService.Security.JwtData;
import com.scaler.ProductService.Security.TokenValidator;
import jakarta.annotation.Nullable;
import org.apache.tomcat.Jar;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.scaler.ProductService.DTOs.RequestProductDTO;
import com.scaler.ProductService.DTOs.ResponseProductDTO;
import com.scaler.ProductService.Exceptions.NotFoundException;
import com.scaler.ProductService.Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private TokenValidator tokenValidator;

    // private OutSourceProductService productService;

    // public ProductController(@Qualifier("fakeStoreProductService")
    // OutSourceProductService productService) {
    // this.productService = productService;
    // }

    public ProductController(ProductService productService, TokenValidator tokenValidator) {
        this.productService = productService;
        this.tokenValidator = tokenValidator;
    }

    @GetMapping
    public List<ResponseProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseProductDTO getProductById(@Nullable @RequestHeader(HttpHeaders.AUTHORIZATION) String authToken
            , @PathVariable("id") String id) throws NotFoundException {
        Optional<JwtData> jwtDataOptional = tokenValidator.validateToken(authToken);
        if (jwtDataOptional.isPresent()) {
            // Business Logic for if the token is valid
        }
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseProductDTO createProduct(@RequestBody RequestProductDTO product) {
        return productService.createProduct(product);
    }

    @PutMapping
    public ResponseProductDTO updateProductById(@RequestBody RequestProductDTO requestProductDTO) throws NotFoundException {
        return productService.updateProduct(requestProductDTO.getId(), requestProductDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseProductDTO> deleteProduct(@PathVariable("id") String id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }

    // specific to this controller
    // @ExceptionHandler(NotFoundException.class)
    // public ResponseEntity<ExceptionDTO> notFoundException(NotFoundException
    // notFoundException) {
    // return new ResponseEntity<>(new ExceptionDTO(HttpStatus.NOT_FOUND,
    // notFoundException.getMessage()),
    // HttpStatus.NOT_FOUND);
    // }
}
