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

    // 1. ADMIN: Ve TODAS las compras
    @GetMapping
    public List<Purchase> getAll() {
        return repo.findAll();
    }

    // 2. 🆕 USUARIO: Ve SOLO sus compras
    // La App llamará a: /api/purchases/my/correo@usuario.com
    @GetMapping("/my/{email}")
    public List<Purchase> getMyPurchases(@PathVariable String email) {
        return repo.findByCustomerEmail(email);
    }

    // 3. Crear compra
    @PostMapping
    public Purchase create(@RequestBody Purchase p) {
        if (p.getDate() == null) {
            p.setDate(LocalDate.now());
        }
        return repo.save(p);
    }
}