package com.chernomurov.hardwareecommerce.dao;

import com.chernomurov.hardwareecommerce.entity.OrderDetail;
import com.chernomurov.hardwareecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderStatus(String orderStatus);
    List<OrderDetail> findByUser(User user);

    List<OrderDetail> findAllByOrderByUserUserName();
}
