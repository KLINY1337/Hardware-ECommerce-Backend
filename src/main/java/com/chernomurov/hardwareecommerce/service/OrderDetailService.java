package com.chernomurov.hardwareecommerce.service;

import com.chernomurov.hardwareecommerce.dao.OrderDetailsDao;
import com.chernomurov.hardwareecommerce.entity.OrderDetails;
import com.chernomurov.hardwareecommerce.entity.OrderInput;
import com.chernomurov.hardwareecommerce.entity.OrderProductQuantity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    private static final String ORDER_PLACED = "Placed";

    private final OrderDetailsDao orderDetailsDao;

    public OrderDetailsService(OrderDetailsDao orderDetailsDao) {
        this.orderDetailsDao = orderDetailsDao;
    }

    public void placeOrder(OrderInput orderInput) {
        List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();

        for (OrderProductQuantity productQuantity : productQuantityList) {
            OrderDetails = new OrderDetails(
                    orderInput.getFullName(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                    ORDER_PLACED,

            )
            
        }
    }
}
