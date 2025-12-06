package com.example.games_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // String
    private String name;

    // Char: código corto (A: Aventura, R: RPG, etc.)
    private char code;

    // Integer: prioridad para ordenar
    private Integer priority;

    // Date: fecha de creación
    private LocalDate createdAt;

    public Category() {
    }

    public Category(Long id, String name, char code, Integer priority, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.priority = priority;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public char getCode() { return code; }
    public void setCode(char code) { this.code = code; }

    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
}
