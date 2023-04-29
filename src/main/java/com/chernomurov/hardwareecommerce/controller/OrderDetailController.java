package com.chernomurov.hardwareecommerce.controller;

import com.chernomurov.hardwareecommerce.entity.OrderInput;
import com.chernomurov.hardwareecommerce.service.OrderDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @PostMapping({"/placeOrder"})
    public void placeOrder(@RequestBody OrderInput orderInput) {
        orderDetailsService.placeOrder(orderInput);
    }
}
