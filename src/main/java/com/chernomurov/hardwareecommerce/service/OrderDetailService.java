package com.chernomurov.hardwareecommerce.service;

import com.chernomurov.hardwareecommerce.configuration.JwtRequestFilter;
import com.chernomurov.hardwareecommerce.dao.OrderDetailDao;
import com.chernomurov.hardwareecommerce.dao.ProductDao;
import com.chernomurov.hardwareecommerce.dao.UserDao;
import com.chernomurov.hardwareecommerce.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    private static final String ORDER_PLACED = "Placed";

    private final OrderDetailDao orderDetailDao;
    private final UserDao userDao;

    private final ProductDao productDao;

    public OrderDetailService(OrderDetailDao orderDetailDao, UserDao userDao, ProductDao productDao) {
        this.orderDetailDao = orderDetailDao;
        this.userDao = userDao;
        this.productDao = productDao;
    }

    public void placeOrder(OrderInput orderInput) {
        List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();

        for (OrderProductQuantity productQuantity : productQuantityList) {
            Product product = productDao.findById(productQuantity.getProductId()).get();

            String currentUser = JwtRequestFilter.CURRENT_USER;
            User user = userDao.findById(currentUser).get();

            OrderDetail orderDetail = new OrderDetail(
                    orderInput.getFullName(),
                    orderInput.getFullAddress(),
                    orderInput.getContactNumber(),
                    orderInput.getAlternateContactNumber(),
                    ORDER_PLACED,
                    product.getProductDiscountedPrice() * productQuantity.getQuantity(),
                    product,
                    user
            );

            orderDetailDao.save(orderDetail);
            
        }
    }
}
