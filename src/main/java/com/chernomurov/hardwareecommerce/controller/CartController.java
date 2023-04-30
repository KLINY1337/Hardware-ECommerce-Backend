package com.chernomurov.hardwareecommerce.controller;

import com.chernomurov.hardwareecommerce.entity.Cart;
import com.chernomurov.hardwareecommerce.service.CartService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping({"/addToCart/{productId}"})
    public Cart addToCart(@PathVariable("productId") Long productId) {
        return cartService.addToCart(productId);
    }
}
