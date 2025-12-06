package com.example.games_service.controller;

import com.example.games_service.model.Game;
import com.example.games_service.repository.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins = "*") // para que la app Android pueda llamar
public class GameController {

    private final GameRepository repo;

    public GameController(GameRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Game> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Game create(@RequestBody Game game) {
        // ignoramos el id que venga y dejamos que JPA lo genere
        game.setId(null);
        return repo.save(game);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setTitle(game.getTitle());
                    existing.setPrice(game.getPrice());
                    existing.setDrawableName(game.getDrawableName());
                    existing.setGenre(game.getGenre());
                    existing.setDurationHours(game.getDurationHours());
                    existing.setShortDesc(game.getShortDesc());
                    existing.setOriginalPrice(game.getOriginalPrice());
                    existing.setDiscountPercent(game.getDiscountPercent());
                    return ResponseEntity.ok(repo.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
