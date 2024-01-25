package com.scaler.ecommerce.Controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
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

import com.scaler.ecommerce.DTOs.GenericProductDTO;
import com.scaler.ecommerce.Exceptions.NotFoundException;
import com.scaler.ecommerce.Models.Product;
import com.scaler.ecommerce.Services.InbuiltProductService;
import com.scaler.ecommerce.Services.OutSourceProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private InbuiltProductService inbuiltProductService;

    public ProductController(InbuiltProductService inbuiltProductService) {
        this.inbuiltProductService = inbuiltProductService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return inbuiltProductService.createProduct(product);
    }

    @PutMapping
    public Product updateProductById(@RequestBody Product product) {
        return inbuiltProductService.updateProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return inbuiltProductService.getAllProducts();
    }

    @GetMapping("{uuid}")
    public Product getProductById(@PathVariable("uuid") String uuid) throws NotFoundException {
        Optional<Product> opt = inbuiltProductService.getProductById(UUID.fromString(uuid));
        if (!opt.isPresent()) {
            throw new NotFoundException("Product with ID : " + uuid.toString() + " not found.");
        }
        return opt.get();
    }

    @DeleteMapping("{uuid}")
    public void deleteProduct(@PathVariable("uuid") String uuid) {
        inbuiltProductService.deleteProduct(UUID.fromString(uuid));
    }

    // private OutSourceProductService productService;

    // public ProductController(@Qualifier("fakeStoreProductService")
    // OutSourceProductService productService) {
    // this.productService = productService;
    // }

    // @PostMapping
    // public GenericProductDTO createProduct(@RequestBody GenericProductDTO
    // genericProductDTO) {
    // return productService.createProduct(genericProductDTO);
    // }

    // @PutMapping("/{id}")
    // public GenericProductDTO updateProductById(@PathVariable("id") Long id,
    // @RequestBody GenericProductDTO genericProductDTO) throws NotFoundException {
    // return productService.updateProduct(id, genericProductDTO);
    // }

    // @GetMapping
    // public List<GenericProductDTO> getAllProducts() {
    // return productService.getAllProducts();
    // }

    // @GetMapping("{id}")
    // public GenericProductDTO getProductById(@PathVariable("id") Long id) throws
    // NotFoundException {
    // return productService.getProductById(id);
    // }

    // @DeleteMapping("{id}")
    // public ResponseEntity<GenericProductDTO> deleteProduct(@PathVariable("id")
    // Long id) {
    // return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    // }

    // specific to this controller
    // @ExceptionHandler(NotFoundException.class)
    // public ResponseEntity<ExceptionDTO> notFoundException(NotFoundException
    // notFoundException) {
    // return new ResponseEntity<>(new ExceptionDTO(HttpStatus.NOT_FOUND,
    // notFoundException.getMessage()),
    // HttpStatus.NOT_FOUND);
    // }
}
