package com.example.biblioteca.controller;

import com.example.biblioteca.model.Prestamo;
import com.example.biblioteca.repository.PrestamoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v1/solicitudes"})
public class PrestamoController {
    @Autowired
    private PrestamoRepository repository;

    @GetMapping
    public List<Prestamo> listar() {
        return this.repository.obtenerTodos();
    }

    @PostMapping
    public Prestamo crear(@RequestBody Prestamo p) {
        return this.repository.guardar(p);
    }

    @GetMapping({"/{id}"})
    public Prestamo obtener(@PathVariable int id) {
        return this.repository.buscarPorId(id);
    }

    @PutMapping({"/{id}"})
    public Prestamo editar(@PathVariable int id, @RequestBody Prestamo p) {
        return this.repository.actualizar(p);
    }

    @DeleteMapping({"/{id}"})
    public Prestamo eliminar(@PathVariable int id) {
        return this.repository.eliminar(id);
    }
}
