package com.example.games_service.controller;

import com.example.games_service.model.AppUser;
import com.example.games_service.repository.AppUserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class AppUserController {

    private final AppUserRepository repo;

    public AppUserController(AppUserRepository repo) {
        this.repo = repo;
    }

    // LISTAR USUARIOS (Para el rol Soporte)
    @GetMapping
    public List<AppUser> getAll() {
        return repo.findAll();
    }

    // REGISTRAR USUARIO (Desde la App)
    @PostMapping
    public AppUser create(@RequestBody AppUser user) {
        // 🛑 ESTO ES LO QUE TE FALTA 👇
        user.setId(null);

        return repo.save(user);
    }
}