package com.chernomurov.hardwareecommerce.service;

import com.chernomurov.hardwareecommerce.dao.ProductDAO;
import com.chernomurov.hardwareecommerce.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product addNewProduct(Product product) {
        return productDAO.save(product);
    }
}
