package com.example.biblioteca.controller;

import com.example.biblioteca.model.Prestamo;
import com.example.biblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/solicitudes")
public class PrestamoController {

    @Autowired
    private PrestamoRepository repository;

    @GetMapping
    public List<Prestamo> listar() {
        return repository.obtenerTodos();
    }

    @PostMapping
    public Prestamo crear(@RequestBody Prestamo p) {
        return repository.guardar(p);
    }

    @GetMapping("/{id}")
    public Prestamo obtener(@PathVariable int id) {
        return repository.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Prestamo editar(@PathVariable int id, @RequestBody Prestamo p) {
        return repository.actualizar(p);
    }

    @DeleteMapping("/{id}")
    public Prestamo eliminar(@PathVariable int id) {
        return repository.eliminar(id);
    }
}