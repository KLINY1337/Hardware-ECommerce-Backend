package com.chernomurov.hardwareecommerce.service;

import com.chernomurov.hardwareecommerce.dao.ProductDao;
import com.chernomurov.hardwareecommerce.entity.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDAO;

    public ProductService(ProductDao productDAO) {
        this.productDAO = productDAO;
    }

    public Product addNewProduct(Product product) {
        return productDAO.save(product);
    }

    public List<Product> getAllProducts(int pageNumber, String searchKey) {

        if (pageNumber != -1){
            Pageable pageable = PageRequest.of(pageNumber, 8);

            if (searchKey.equals("")) {
                return productDAO.findAll(pageable).getContent();
            }
            else {
                return productDAO.findByProductNameContainsIgnoreCaseOrProductDescriptionContainsIgnoreCase(searchKey, searchKey, pageable);
            }
        }
        else {
            return productDAO.findAll();
        }
    }

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public void deleteProductDetails(Long productId) {
        productDAO.deleteById(productId);
    }

    public Product getProductDetailsById(Long productId) {
        return productDAO.findById(productId).get();
    }

    public List<Product> getProductDetails(boolean isSingleProductCheckout,
                      Long productId) {
        if(isSingleProductCheckout) {
            //TODO going to buy single product

            List<Product> productList = new ArrayList<>();

            Product product = productDAO.findById(productId).get();
            productList.add(product);

            return productList;
        }
        else {
            //TODO checkout entire cart
        }

        return new ArrayList<>();
    }
}
