package com.example.ecommerce.dao;

import com.example.ecommerce.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientDao {
    private final JdbcTemplate jdbc;

    private final RowMapper<Client> mapper = (rs, rowNum) ->
            new Client(rs.getLong("id"), rs.getString("name"), rs.getString("email"));

    public Client create(Client c) {
        String sql = "INSERT INTO client(name, email) VALUES (?, ?) RETURNING id";
        Long id = jdbc.queryForObject(sql, Long.class, c.getName(), c.getEmail());
        c.setId(id);
        return c;
    }

    public Optional<Client> findById(Long id) {
        String sql = "SELECT id, name, email FROM client WHERE id = ?";
        return jdbc.query(sql, mapper, id).stream().findFirst();
    }
}
