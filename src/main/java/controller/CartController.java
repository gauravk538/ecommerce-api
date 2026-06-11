package com.gaurav.ecommerce.controller;

import com.gaurav.ecommerce.model.CartItem;
import com.gaurav.ecommerce.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartItemRepository cartItemRepository;

    // GET - Saari cart dekho
    @GetMapping
    public List<CartItem> getCart() {
        return cartItemRepository.findAll();
    }

    // POST - Item cart mein daalo
    @PostMapping
    public CartItem addToCart(@RequestBody CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    // DELETE - Item cart se hatao
    @DeleteMapping("/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartItemRepository.deleteById(id);
        return "Item removed from cart";
    }
}