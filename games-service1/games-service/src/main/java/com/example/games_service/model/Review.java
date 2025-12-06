package com.example.games_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // quién hizo la reseña
    private String author;

    // nota del 1 al 5
    private int rating;

    // comentario
    private String comment;

    // fecha de la reseña
    private LocalDate createdAt;

    // 🔹 relación: muchas reviews pertenecen a un juego
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Review() {
    }

    public Review(Long id,
                  String author,
                  int rating,
                  String comment,
                  LocalDate createdAt,
                  Game game) {
        this.id = id;
        this.author = author;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
        this.game = game;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }

    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }
}
