package com.chernomurov.hardwareecommerce.dao;

import com.chernomurov.hardwareecommerce.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {
}
