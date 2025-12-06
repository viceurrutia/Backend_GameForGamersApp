package com.example.games_service.repository;

import com.example.games_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    // para obtener reviews de un juego específico
    List<Review> findByGameId(Long gameId);
}
