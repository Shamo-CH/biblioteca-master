package com.example.biblioteca.model;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Libro {

    public int id,fechaPublicacion;
    public String isbn, titulo, editorial, autor;

    public Libro(int id, int fechaPublicacion, String isbn, String titulo, String autor, String editorial) {
        this.id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
    }


}
