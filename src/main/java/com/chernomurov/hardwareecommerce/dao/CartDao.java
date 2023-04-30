package com.chernomurov.hardwareecommerce.dao;

import com.chernomurov.hardwareecommerce.entity.Cart;
import com.chernomurov.hardwareecommerce.entity.Product;
import com.chernomurov.hardwareecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {
    boolean existsByProduct(Product product);
    List<Cart> findByUser(User user);
}
