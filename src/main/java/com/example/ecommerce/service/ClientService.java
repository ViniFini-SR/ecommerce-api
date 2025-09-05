package com.example.ecommerce.service;

import com.example.ecommerce.dao.ClientDao;
import com.example.ecommerce.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientDao dao;

    public Client create(Client c) {
        if(c.getEmail() == null || c.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email é obrigatório");
        }
        return dao.create(c);
    }

    public Client findById(Long id) {
        return dao.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }
}