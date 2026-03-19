package com.example.biblioteca.repository;

import com.example.biblioteca.model.Prestamo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PrestamoRepository {

    private List<Prestamo> prestamos = new ArrayList<>();
    private int ultimoId = 0; // Para simular el auto-incrementable

    public List<Prestamo> obtenerTodos() {
        return prestamos;
    }

    public Prestamo buscarPorId(int id) {
        return prestamos.stream()
                .filter(p -> p.getId_prestamo() == id)
                .findFirst()
                .orElse(null);
    }

    public Prestamo guardar(Prestamo nuevo) {
        ultimoId++;
        nuevo.setId_prestamo(ultimoId); // Simulamos el incremento
        if (nuevo.getMultas() == 0) { nuevo.setMultas(0); } // Aseguramos el default
        prestamos.add(nuevo);
        return nuevo;
    }

    public Prestamo actualizar(Prestamo actualizado) {
        int posicion = -1;

        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getId_prestamo() == actualizado.getId_prestamo()) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            prestamos.set(posicion, actualizado);
            return actualizado;
        }
        return null;
    }

        Prestamo p = buscarPorId(id);
        if (p != null) {
            prestamos.remove(p);
        }
    }

    public PrestamoRepository() {
        // Datos de prueba opcionales para que no esté vacío
        prestamos.add(new Prestamo(1, 1, "12345678-9", LocalDate.now(), null, 7, 0));
    }
}