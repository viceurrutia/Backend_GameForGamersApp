package com.example.games_service;

import com.example.games_service.model.Category;
import com.example.games_service.model.Game;
import com.example.games_service.model.Review;
import com.example.games_service.repository.CategoryRepository;
import com.example.games_service.repository.GameRepository;
import com.example.games_service.repository.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class GamesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamesServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(GameRepository gameRepo,
                               CategoryRepository categoryRepo,
                               ReviewRepository reviewRepo) {
        return args -> {

            // Para no duplicar si ya hay datos
            if (gameRepo.count() > 0) return;

            // 📌 Categorías
            Category aventura = categoryRepo.save(
                    new Category(null, "Aventura", 'A', 1, LocalDate.now())
            );
            Category rpg = categoryRepo.save(
                    new Category(null, "RPG", 'R', 2, LocalDate.now())
            );
            Category plataformas = categoryRepo.save(
                    new Category(null, "Plataformas", 'P', 3, LocalDate.now())
            );

            // 📌 Juegos (catálogo sin oferta) -> AÑADIDO STOCK AL FINAL (ej: 10)
            Game zelda = new Game(
                    null,
                    "Zelda TOTK",
                    "$39.990",
                    "zelda",
                    "Aventura",
                    60,
                    "Explora Hyrule con nuevas habilidades",
                    null,
                    0,
                    10 // Stock
            );
            zelda.setCategory(aventura);
            gameRepo.save(zelda);

            Game elden = new Game(
                    null,
                    "Elden Ring",
                    "$49.990",
                    "eldenring",
                    "RPG",
                    100,
                    "Mundo abierto desafiante y jefes épicos",
                    null,
                    0,
                    15 // Stock
            );
            elden.setCategory(rpg);
            gameRepo.save(elden);

            Game mario = new Game(
                    null,
                    "Super Mario Wonder",
                    "$39.990",
                    "mario",
                    "Plataformas",
                    12,
                    "Plataformas moderno y creativo",
                    null,
                    0,
                    20 // Stock
            );
            mario.setCategory(plataformas);
            gameRepo.save(mario);

            // 🔹 Spider-Man 2 (catálogo)
            Game spiderman = new Game(
                    null,
                    "Spider-Man 2",
                    "$59.990",
                    "spiderman",
                    "Acción",
                    20,
                    "Aventura trepidante en NY",
                    null,
                    0,
                    8 // Stock
            );
            spiderman.setCategory(aventura);
            gameRepo.save(spiderman);

            // 🔹 Cyberpunk 2077 (catálogo)
            Game cyberpunk = new Game(
                    null,
                    "Cyberpunk 2077",
                    "$29.990",
                    "cyberpunk",
                    "RPG",
                    35,
                    "Historia profunda en Night City",
                    null,
                    0,
                    12 // Stock
            );
            cyberpunk.setCategory(rpg);
            gameRepo.save(cyberpunk);

            // 📌 Ofertas del momento
            Game silksong = new Game(
                    null,
                    "Hollow Knight: Silksong",
                    "$19.990",
                    "silksong",
                    "Metroidvania",
                    30,
                    "Secuela esperada",
                    "$19.990",
                    30,
                    5 // Stock bajo
            );
            silksong.setCategory(aventura);
            gameRepo.save(silksong);

            Game witcher = new Game(
                    null,
                    "The Witcher 3",
                    "$39.990",
                    "witcher3",
                    "RPG",
                    80,
                    "Aventura épica en mundo abierto",
                    "$39.990",
                    50,
                    10 // Stock
            );
            witcher.setCategory(rpg);
            gameRepo.save(witcher);

            // 🔹 Resident Evil 4 Remake (oferta)
            Game re4 = new Game(
                    null,
                    "Resident Evil 4 Remake",
                    "$19.990",
                    "re4",
                    "Survival Horror",
                    25,
                    "Remake del clásico de acción y terror",
                    "$19.990",
                    15,
                    10 // Stock
            );
            re4.setCategory(aventura);
            gameRepo.save(re4);

            // 📌 Reviews de ejemplo
            reviewRepo.save(new Review(
                    null,
                    "Jugador 1",
                    5,
                    "Una obra maestra, muchas horas de juego.",
                    LocalDate.now(),
                    zelda
            ));

            reviewRepo.save(new Review(
                    null,
                    "Jugador 2",
                    4,
                    "Muy buen RPG, aunque algo difícil.",
                    LocalDate.now(),
                    elden
            ));

            reviewRepo.save(new Review(
                    null,
                    "Jugador 3",
                    5,
                    "Perfecto para jugar en familia.",
                    LocalDate.now(),
                    mario
            ));
        };
    }
}