package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService service;

    @GetMapping()
    public List<Libro> listarLibros(){
        return service.getLibros();
    }

    @PostMapping()
    public Libro agregarLibro(@RequestBody Libro libro){
        return service.save(libro);
    }

    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id){
        return service.get(id);
    }

    @PutMapping("{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro){
        return service.update(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return service.deleteLibro(id);
    }
    @GetMapping("/total")
    public int totalLibrosV2(){
        return service.totalLibrosV2();
    }



}
