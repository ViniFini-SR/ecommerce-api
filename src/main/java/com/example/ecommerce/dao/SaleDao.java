package com.example.ecommerce.dao;

import com.example.ecommerce.model.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SaleDao {
    private final JdbcTemplate jdbc;

    public Sale create(Sale s) {
        String sql = "INSERT INTO sale(client_id, sku, quantity, price) VALUES(?, ?, ?, ?) RETURNING id";
        Long id = jdbc.queryForObject(sql, Long.class, s.getClientId(), s.getSku(), s.getQuantity(), s.getPrice());
        s.setId(id);
        return s;
    }
}