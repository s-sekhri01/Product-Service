package com.scaler.ecommerce.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scaler.ecommerce.DTOs.RequestProductDTO;
import com.scaler.ecommerce.DTOs.ResponseProductDTO;
import com.scaler.ecommerce.Exceptions.NotFoundException;
import com.scaler.ecommerce.Services.InbuiltProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private InbuiltProductService inbuiltProductService;

    public ProductController(InbuiltProductService inbuiltProductService) {
        this.inbuiltProductService = inbuiltProductService;
    }

    @GetMapping
    public List<ResponseProductDTO> getAllProducts() {
        return inbuiltProductService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseProductDTO getProductById(@PathVariable("id") String id) throws NotFoundException {
        return inbuiltProductService.getProductById(id);
    }

    @PostMapping
    public ResponseProductDTO createProduct(@RequestBody RequestProductDTO product) {
        return inbuiltProductService.createOrUpdateProduct(product);
    }

    @PutMapping
    public ResponseProductDTO updateProductById(@RequestBody RequestProductDTO product) {
        return inbuiltProductService.createOrUpdateProduct(product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable("id") String id) {
        inbuiltProductService.deleteProduct(id);
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
