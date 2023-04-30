package com.chernomurov.hardwareecommerce.controller;

import com.chernomurov.hardwareecommerce.dao.CartDao;
import com.chernomurov.hardwareecommerce.entity.Cart;
import com.chernomurov.hardwareecommerce.service.CartService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    private final CartService cartService;
    private final CartDao cartDao;

    public CartController(CartService cartService,
                          CartDao cartDao) {
        this.cartService = cartService;
        this.cartDao = cartDao;
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping({"/addToCart/{productId}"})
    public Cart addToCart(@PathVariable("productId") Long productId) {
        return cartService.addToCart(productId);
    }
    @PreAuthorize("hasRole('User')")
    @GetMapping({"/getCartDetails"})
    public List<Cart> getCartDetails() {
        return cartService.getCartDetails();
    }
}
