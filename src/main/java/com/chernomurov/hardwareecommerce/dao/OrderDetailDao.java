package com.chernomurov.hardwareecommerce.dao;

import com.chernomurov.hardwareecommerce.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Long> {
}
