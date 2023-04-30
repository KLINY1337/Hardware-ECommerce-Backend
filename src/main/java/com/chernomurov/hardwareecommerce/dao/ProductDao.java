package com.chernomurov.hardwareecommerce.dao;

import com.chernomurov.hardwareecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    List<Product> findByProductNameContainsIgnoreCaseOrProductDescriptionContainsIgnoreCase(String productName, String productDescription, Pageable pageable);

    Page<Product> findAll(Pageable pageable);
}
