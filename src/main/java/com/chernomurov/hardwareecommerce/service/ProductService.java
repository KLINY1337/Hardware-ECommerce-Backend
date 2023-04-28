package com.chernomurov.hardwareecommerce.service;

import com.chernomurov.hardwareecommerce.dao.ProductDAO;
import com.chernomurov.hardwareecommerce.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product addNewProduct(Product product) {
        return productDAO.save(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public void deleteProductDetails(Long productId) {
        productDAO.deleteById(productId);
    }
}
