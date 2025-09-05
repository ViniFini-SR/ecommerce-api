package com.example.ecommerce.service;

import com.example.ecommerce.dao.SaleDao;
import com.example.ecommerce.dao.ClientDao;
import com.example.ecommerce.model.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleDao saleDao;
    private final ClientDao clientDao;

    public Sale create(Sale s) {
        // Validacoes
        if (clientDao.findById(s.getClientId()).isEmpty()) {
            throw new IllegalArgumentException("Cliente não encontrato");
        }
        if (s.getQuantity() == null || s.getQuantity() <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que 0");
        }
        if (s.getPrice() == null) {
            throw new IllegalArgumentException("Preço é obrigatório");
        }

        return saleDao.create(s);
    }
}