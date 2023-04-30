package com.chernomurov.hardwareecommerce.service;

import com.chernomurov.hardwareecommerce.configuration.JwtRequestFilter;
import com.chernomurov.hardwareecommerce.dao.CartDao;
import com.chernomurov.hardwareecommerce.dao.ProductDao;
import com.chernomurov.hardwareecommerce.dao.UserDao;
import com.chernomurov.hardwareecommerce.entity.Cart;
import com.chernomurov.hardwareecommerce.entity.Product;
import com.chernomurov.hardwareecommerce.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartDao cartDao;

    private final ProductDao productDao;
    private final UserDao userDao;

    public CartService(CartDao cartDao, ProductDao productDao, UserDao userDao) {
        this.cartDao = cartDao;
        this.productDao = productDao;
        this.userDao = userDao;
    }

    public Cart addToCart(Long productId) {
        Product product = productDao.findById(productId).get();
        String userName = JwtRequestFilter.CURRENT_USER;

        User user = null;
        if (userName != null) {
            user = userDao.findById(userName).get();
        }

        if (product != null && user != null) {
            Cart cart = new Cart(product, user);

            return cartDao.save(cart);
        }
        return null;
    }

    public List<Cart> getCartDetails() {
        User user = userDao.findById(JwtRequestFilter.CURRENT_USER).get();

        return cartDao.findByUser(user);
    }
}
