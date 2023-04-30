package com.chernomurov.hardwareecommerce.service;

import com.chernomurov.hardwareecommerce.configuration.JwtRequestFilter;
import com.chernomurov.hardwareecommerce.dao.CartDao;
import com.chernomurov.hardwareecommerce.dao.OrderDetailDao;
import com.chernomurov.hardwareecommerce.dao.ProductDao;
import com.chernomurov.hardwareecommerce.dao.UserDao;
import com.chernomurov.hardwareecommerce.entity.*;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailService {

    private static final String ORDER_PLACED = "Placed";

    private final OrderDetailDao orderDetailDao;
    private final UserDao userDao;

    private final ProductDao productDao;
    private final CartDao cartDao;

    public OrderDetailService(OrderDetailDao orderDetailDao, UserDao userDao, ProductDao productDao, CartDao cartDao) {
        this.orderDetailDao = orderDetailDao;
        this.userDao = userDao;
        this.productDao = productDao;
        this.cartDao = cartDao;
    }

    public void placeOrder(OrderInput orderInput, boolean isSingleProductCheckout) {
        List<OrderProductQuantity> productQuantityList = orderInput.getOrderProductQuantityList();
        User user = userDao.findById(JwtRequestFilter.CURRENT_USER).get();

        for (OrderProductQuantity productQuantity : productQuantityList) {
            Product product = productDao.findById(productQuantity.getProductId()).get();

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

        if (!isSingleProductCheckout) {
            List<Cart> carts = cartDao.findByUser(user);
            cartDao.deleteAllById(carts.stream().map(Cart::getCartId).collect(Collectors.toList()));
        }
    }

    public List<OrderDetail> getOrderDetails() {
        User user = userDao.findById(JwtRequestFilter.CURRENT_USER).get();

        return orderDetailDao.findByUser(user);
    }

    public List<OrderDetail> getAllOrders() {
        return orderDetailDao.findAllByOrderByUserUserName();
    }
 }
