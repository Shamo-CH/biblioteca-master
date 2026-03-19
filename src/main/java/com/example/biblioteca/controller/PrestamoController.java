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
    public ResponseEntity<Prestamo> crear(@RequestBody Prestamo p) {
        Prestamo nuevo = repository.guardar(p);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> obtener(@PathVariable int id) {
        Prestamo p = repository.buscarPorId(id);
        return (p != null) ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> editar(@PathVariable int id, @RequestBody Prestamo p) {
        p.setId_prestamo(id);
        Prestamo actualizado = repository.actualizar(p);
        return (actualizado != null) ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        repository.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}