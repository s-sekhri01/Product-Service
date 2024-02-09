package com.scaler.ProductService.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.ProductService.DTOs.RequestProductDTO;
import com.scaler.ProductService.DTOs.ResponseProductDTO;
import com.scaler.ProductService.Exceptions.NotFoundException;
import com.scaler.ProductService.Services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    // private OutSourceProductService productService;

    // public ProductController(@Qualifier("fakeStoreProductService")
    // OutSourceProductService productService) {
    // this.productService = productService;
    // }

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ResponseProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseProductDTO getProductById(@PathVariable("id") String id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseProductDTO createProduct(@RequestBody RequestProductDTO product) {
        return productService.createProduct(product);
    }

    @PutMapping
    public ResponseProductDTO updateProductById(@RequestBody RequestProductDTO requestProductDTO)
            throws NotFoundException {
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
