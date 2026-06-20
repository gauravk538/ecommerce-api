package com.gaurav.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name cannot be empty")
    private String customerName;

    @NotNull(message = "Total amount cannot be null")
    @Min(value = 0, message = "Total amount cannot be negative")
    private Double totalAmount;

    private String status;

    private LocalDateTime orderDate;
}