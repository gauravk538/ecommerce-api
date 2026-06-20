package com.gaurav.ecommerce.service;

import com.gaurav.ecommerce.model.CartItem;
import com.gaurav.ecommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    // Get all cart items
    public List<CartItem> getCart() {
        return cartItemRepository.findAll();
    }

    // Add item to cart
    public CartItem addToCart(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    // Remove item from cart
    public void removeFromCart(Long id) {
        cartItemRepository.deleteById(id);
    }

    // Clear entire cart
    public void clearCart() {
        cartItemRepository.deleteAll();
    }
}