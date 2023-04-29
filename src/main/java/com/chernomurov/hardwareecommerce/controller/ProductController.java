package com.chernomurov.hardwareecommerce.controller;


import com.chernomurov.hardwareecommerce.entity.ImageModel;
import com.chernomurov.hardwareecommerce.entity.Product;
import com.chernomurov.hardwareecommerce.service.ImageService;
import com.chernomurov.hardwareecommerce.service.ProductService;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@RestController
public class ProductController {

    private final ProductService productService;

    private final ImageService imageService;

    public ProductController(ProductService productService, ImageService imageService) {
        this.productService = productService;
        this.imageService = imageService;
    }

    @PostMapping(value = {"/addNewProduct"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @PreAuthorize("hasRole('Admin')")
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("imageFile")MultipartFile[] file) {

        try {
            Set<ImageModel> images = imageService.uploadImage(file);
            product.setProductImages(images);

            return productService.addNewProduct(product);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping({"/getAllProducts"})
    //@PreAuthorize("hasRole('Admin')")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping({"/deleteProductDetails/{productId}"})
    @PreAuthorize("hasRole('Admin')")
    public void deleteProductDetails(@PathVariable("productId") Long productId) {
        productService.deleteProductDetails(productId);
    }

    @GetMapping({"/getProductDetailsById/{productId}"})
    @PreAuthorize("hasRole('Admin')")
    public Product getProductDetailsById(@PathVariable("productId") Long productId) {
        return productService.getProductDetailsById(productId);
    }
}
