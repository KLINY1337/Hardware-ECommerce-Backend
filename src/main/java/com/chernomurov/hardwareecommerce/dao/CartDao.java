package com.chernomurov.hardwareecommerce.dao;

import com.chernomurov.hardwareecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends JpaRepository<Cart, Long> {
}
