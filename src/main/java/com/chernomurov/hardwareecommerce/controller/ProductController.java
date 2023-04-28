package com.chernomurov.hardwareecommerce.controller;


import com.chernomurov.hardwareecommerce.entity.Product;
import com.chernomurov.hardwareecommerce.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping({"/addNewProduct"})
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }
}
