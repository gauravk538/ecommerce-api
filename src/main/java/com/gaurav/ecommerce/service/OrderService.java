package com.gaurav.ecommerce.service;

import com.gaurav.ecommerce.model.Order;
import com.gaurav.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Place new order
    public Order placeOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Update order status
    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }

    // Cancel order
    public Order cancelOrder(Long id) {
        return updateOrderStatus(id, "CANCELLED");
    }
}