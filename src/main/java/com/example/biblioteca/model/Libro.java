package com.example.biblioteca.model;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Libro {
// LAS EXCEPCIONES SIEMPRE EN EL MODELO
    //HOLA SOY UNA NOTA
    // EL @VALID VA EN EL CONTROLADOR DEL LIBRO O EN EL CONTROLADOR
// no negros (Not blank) nah en realidad funciona para cambiar la desc)
    //teban carreando la clase manga de nebros :D
    public int id;
    @NotNull
    public int fechaPublicacion;
    public String isbn;
    @NotBlank(message = "Cmo tan leso de dejarlo vacio jaja ")
    public String titulo, editorial, autor;

    public Libro(int id, int fechaPublicacion, String isbn, String titulo, String autor, String editorial) {
        this.id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
    }


}
