package com.example.ecommerce.controller;

import com.example.ecommerce.model.Client;
import com.example.ecommerce.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final ClientService svc;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client c) {
        Client created = svc.create(c);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> get(@PathVariable Long id) {
        try {
            Client client = svc.findById(id);
            return ResponseEntity.ok(client);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
