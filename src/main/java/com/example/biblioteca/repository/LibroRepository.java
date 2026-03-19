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

    public LibroRepository(){
        libros.add(new Libro(1, 2018, "9789569646638", "Fuego y Sangre","George R. R. Martin","Penguin Random House Grupo Editorial"));
        libros.add(new Libro(2,2014,"9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias","Sergio Gomez", "Sm Ediciones"));
        libros.add(new Libro(3,2020, "9781484256251", "Spring Boot Persistence Best Practices","J.K Rowling", "Salamandra"));
        libros.add(new Libro(4,2024,"9785660757552","Harry Potter y la Piedra Filosofal","J.K Rowling", "Scholastic"));
        libros.add(new Libro(5,1999,"9780439139601","Harry Potter y El Prisionero de Azkaban","J.K Rowling", "Scholastic"));
        libros.add(new Libro(6,2000,"9780439136365","Harry Potter y el cáliz de fuego","J.K Rowling", "Scholastic"));
        libros.add(new Libro(7,2008,"9780321127426","Effective Java","Joshua Bloch","Addison Wesley"));
        libros.add(new Libro(8,2017,"9780134685991","Clean Architecture","Robert C. Martin", "Prentice Hall"));
        libros.add(new Libro(9,1994,"9780201633610","Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "Addison Wesley"));
        libros.add(new Libro(10,2008,"9780132350884","Clean code", "Robert C. Martin", "Prentice Hall"));

    }


}
