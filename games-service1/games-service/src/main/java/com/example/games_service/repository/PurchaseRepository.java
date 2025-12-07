package com.example.games_service.repository;

import com.example.games_service.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // 👈 Importante

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    // 🆕 NUEVO: Buscar compras por email del cliente
    List<Purchase> findByCustomerEmail(String customerEmail);
}