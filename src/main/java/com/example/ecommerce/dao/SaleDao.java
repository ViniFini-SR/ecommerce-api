package com.example.ecommerce.dao;

import com.example.ecommerce.model.Sale;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SaleDao {
    private final JdbcTemplate jdbc;

    public SaleDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Sale create(Sale s) {
        String sql = "INSERT INTO sale(client_id, sku, quantity, price) VALUES(?, ?, ?, ?) RETURNING id";
        Long id = jdbc.queryForObject(sql, Long.class, s.getClientId(), s.getSku(), s.getQuantity(), s.getPrice());
        s.setId(id);
        return s;
    }
}