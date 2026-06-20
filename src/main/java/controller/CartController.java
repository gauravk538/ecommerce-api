package com.gaurav.ecommerce.controller;

import com.gaurav.ecommerce.model.CartItem;
import com.gaurav.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // GET - Saari cart dekho
    @GetMapping
    public List<CartItem> getCart() {
        return cartService.getCart();
    }

    // POST - Item cart mein daalo
    @PostMapping
    public CartItem addToCart(@RequestBody CartItem cartItem) {
        return cartService.addToCart(cartItem);
    }

    // DELETE - Item cart se hatao
    @DeleteMapping("/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return "Item removed from cart";
    }

    // DELETE - Poori cart clear karo
    @DeleteMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "Cart cleared successfully";
    }
}