package com.example.games_service.controller;

import com.example.games_service.model.Game;
import com.example.games_service.model.Review;
import com.example.games_service.repository.GameRepository;
import com.example.games_service.repository.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewRepository reviewRepo;
    private final GameRepository gameRepo;

    public ReviewController(ReviewRepository reviewRepo, GameRepository gameRepo) {
        this.reviewRepo = reviewRepo;
        this.gameRepo = gameRepo;
    }

    // Todas las reviews
    @GetMapping
    public List<Review> all() {
        return reviewRepo.findAll();
    }

    // Reviews de un juego específico
    @GetMapping("/game/{gameId}")
    public List<Review> byGame(@PathVariable Long gameId) {
        return reviewRepo.findByGameId(gameId);
    }

    // Crear review para un juego
    @PostMapping("/game/{gameId}")
    public Review createForGame(@PathVariable Long gameId, @RequestBody Review r) {
        Game g = gameRepo.findById(gameId).orElseThrow();
        r.setId(null);
        r.setGame(g);
        if (r.getCreatedAt() == null) {
            r.setCreatedAt(LocalDate.now());
        }
        return reviewRepo.save(r);
    }

    // Eliminar review
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewRepo.deleteById(id);
    }
}
