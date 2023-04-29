package com.chernomurov.hardwareecommerce.controller;

import com.chernomurov.hardwareecommerce.entity.OrderInput;
import com.chernomurov.hardwareecommerce.service.OrderDetailService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping({"/placeOrder"})
    @PreAuthorize("hasRole('User')")
    public void placeOrder(@RequestBody OrderInput orderInput) {
        orderDetailService.placeOrder(orderInput);
    }
}
