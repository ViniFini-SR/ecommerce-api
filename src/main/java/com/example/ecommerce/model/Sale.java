package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    private Long id;
    private Long clientId;
    private String sku;
    private Integer quantity;
    private BigDecimal price;
    private OffsetDateTime soldAt;
}