package com.example.games_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private int totalAmount;
    private String customerEmail;

    // 🆕 NUEVOS CAMPOS PARA MOSTRAR EN EL HISTORIAL
    private String itemsInfo; // Ej: "Zelda x1, Mario x2"
    private String imageCode; // Ej: "zelda" (para mostrar la fotito)

    public Purchase() {}

    public Purchase(Long id, LocalDate date, int totalAmount, String customerEmail, String itemsInfo, String imageCode) {
        this.id = id;
        this.date = date;
        this.totalAmount = totalAmount;
        this.customerEmail = customerEmail;
        this.itemsInfo = itemsInfo;
        this.imageCode = imageCode;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getTotalAmount() { return totalAmount; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    // 🆕 Getters y Setters nuevos
    public String getItemsInfo() { return itemsInfo; }
    public void setItemsInfo(String itemsInfo) { this.itemsInfo = itemsInfo; }

    public String getImageCode() { return imageCode; }
    public void setImageCode(String imageCode) { this.imageCode = imageCode; }
}