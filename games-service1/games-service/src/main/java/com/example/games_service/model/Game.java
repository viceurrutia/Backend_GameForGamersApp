package com.example.games_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // 🆕 Importar esto
import jakarta.persistence.*;
import java.util.ArrayList; // 🆕 Importar esto
import java.util.List;      // 🆕 Importar esto

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String price;
    private String drawableName;
    private String genre;
    private int durationHours;
    private String shortDesc;
    private String originalPrice;
    private int discountPercent;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // 🆕 ESTO ES LO QUE SOLUCIONA EL ERROR AL ELIMINAR:
    // "cascade = CascadeType.ALL" significa: Si borro el Juego, borra todas sus Reviews.
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Evita errores de "bucle infinito" al enviar los datos a Android
    private List<Review> reviews = new ArrayList<>();

    public Game() {
    }

    public Game(Long id,
                String title,
                String price,
                String drawableName,
                String genre,
                int durationHours,
                String shortDesc,
                String originalPrice,
                int discountPercent,
                int stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.drawableName = drawableName;
        this.genre = genre;
        this.durationHours = durationHours;
        this.shortDesc = shortDesc;
        this.originalPrice = originalPrice;
        this.discountPercent = discountPercent;
        this.stock = stock;
    }

    // Getters y setters antiguos...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getDrawableName() { return drawableName; }
    public void setDrawableName(String drawableName) { this.drawableName = drawableName; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getDurationHours() { return durationHours; }
    public void setDurationHours(int durationHours) { this.durationHours = durationHours; }

    public String getShortDesc() { return shortDesc; }
    public void setShortDesc(String shortDesc) { this.shortDesc = shortDesc; }

    public String getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(String originalPrice) { this.originalPrice = originalPrice; }

    public int getDiscountPercent() { return discountPercent; }
    public void setDiscountPercent(int discountPercent) { this.discountPercent = discountPercent; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    // 🆕 Getters y Setters para las Reviews (Necesario para que JPA funcione bien)
    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }
}