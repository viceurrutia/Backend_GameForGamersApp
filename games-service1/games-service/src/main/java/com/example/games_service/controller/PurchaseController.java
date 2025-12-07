package com.example.games_service.controller;

import com.example.games_service.model.Purchase;
import com.example.games_service.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin(origins = "*")
public class PurchaseController {

    private final PurchaseRepository repo;

    public PurchaseController(PurchaseRepository repo) {
        this.repo = repo;
    }

    // El Admin llama aquí para ver el historial
    @GetMapping
    public List<Purchase> getAll() {
        return repo.findAll();
    }

    // La App llama aquí cuando el usuario da "Confirmar Compra"
    @PostMapping
    public Purchase create(@RequestBody Purchase p) {
        if (p.getDate() == null) {
            p.setDate(LocalDate.now());
        }
        return repo.save(p);
    }
}