package com.example.games_service.controller;

import com.example.games_service.model.Category;
import com.example.games_service.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryRepository repo;

    public CategoryController(CategoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Category> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Category one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Category create(@RequestBody Category c) {
        return repo.save(c);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category c) {
        Category existing = repo.findById(id).orElseThrow();
        existing.setName(c.getName());
        existing.setCode(c.getCode());
        existing.setPriority(c.getPriority());
        existing.setCreatedAt(c.getCreatedAt());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
