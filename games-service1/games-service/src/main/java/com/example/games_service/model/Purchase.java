package com.example.games_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private int totalAmount; // El total de la compra
    private String customerEmail; // Quién compró

    public Purchase() {}

    public Purchase(Long id, LocalDate date, int totalAmount, String customerEmail) {
        this.id = id;
        this.date = date;
        this.totalAmount = totalAmount;
        this.customerEmail = customerEmail;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getTotalAmount() { return totalAmount; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
}