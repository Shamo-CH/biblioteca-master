package com.example.biblioteca.repository;


import com.example.biblioteca.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    List<Libro> libros = new ArrayList<>();

    public List<Libro> obtenerLibros() {
        return libros;
    }

    public Libro buscarPorId(int id){
        return libros.stream()
                .filter(libro -> libro.getId() == id)
                .findFirst().get();
    }

    public Libro buscarPorISBN(String isbn){
        return libros.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst().get();
    }

    public Libro guardar(Libro nuevo){
        libros.add(nuevo);
        return nuevo;
    }

    public Libro actualizar(Libro nuevo){
        int id = 0;
        int idPosicion = 0;

        for(int i = 0; i <libros.size(); i++){
            if (libros.get(i).getId() == nuevo.getId()){
                id = nuevo.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(nuevo.getTitulo());
        libro1.setAutor(nuevo.getAutor());
        libro1.setFechaPublicacion(nuevo.getFechaPublicacion());
        libro1.setEditorial(nuevo.getEditorial());
        libro1.setIsbn(nuevo.getIsbn());

        libros.set(idPosicion, libro1);
        return libro1;
    }

    public void eliminar(int id){
        Libro libro = buscarPorId(id);
        if(libro != null){
            libros.remove(libro);
        }
    }
    public int totalLibros(){
        return libros.size();
    }
}
