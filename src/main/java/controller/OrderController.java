package com.gaurav.ecommerce.controller;

import com.gaurav.ecommerce.model.Order;
import com.gaurav.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // POST - Order place karo
    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");
        return orderRepository.save(order);
    }

    // GET - Saare orders dekho
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // GET - Ek order dekho
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // PUT - Order status update karo
    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestParam String status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }
}