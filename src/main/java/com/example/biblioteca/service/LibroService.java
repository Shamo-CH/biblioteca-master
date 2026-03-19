package com.example.biblioteca.service;


import com.example.biblioteca.model.Libro;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;

    public List<Libro> getLibros(){
        return repository.obtenerLibros();
    }

    public Libro save(Libro nuevo){
        return repository.guardar(nuevo);
    }

    public Libro get(int id){
        return repository.buscarPorId(id);
    }

    public Libro update(Libro libro){
        return repository.actualizar(libro);
    }

    public String deleteLibro(int id){
        repository.eliminar(id);
        return "se borro :)";
    }
    public int totalLibrosV1(){
        return repository.obtenerLibros().size();

    }
    public int totalLibrosV2(){
        return repository.totalLibros();
    }
}
