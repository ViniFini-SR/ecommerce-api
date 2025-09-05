package com.example.ecommerce.controller;

import com.example.ecommerce.model.Sale;
import com.example.ecommerce.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sales")
public class SaleController {
    private final SaleService svc;

    @PostMapping
    public ResponseEntity<Sale> create(@RequestBody Sale s) {
        try {
            Sale created = svc.create(s);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
