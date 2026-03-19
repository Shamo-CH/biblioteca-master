package com.example.biblioteca.repository;

import com.example.biblioteca.model.Prestamo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PrestamoRepository {
    private List<Prestamo> prestamos = new ArrayList();
    private int ultimoId = 0;

    public List<Prestamo> obtenerTodos() {
        return this.prestamos;
    }

    public Prestamo buscarPorId(int id) {
        return (Prestamo)this.prestamos.stream().filter((p) -> p.getId_prestamo() == id).findFirst().orElse((Prestamo) null);
    }

    public Prestamo guardar(Prestamo nuevo) {
        ++this.ultimoId;
        nuevo.setId_prestamo(this.ultimoId);
        if (nuevo.getMultas() == 0) {
            nuevo.setMultas(0);
        }

        this.prestamos.add(nuevo);
        return nuevo;
    }

    public Prestamo actualizar(Prestamo actualizado) {
        int posicion = -1;

        for(int i = 0; i < this.prestamos.size(); ++i) {
            if (((Prestamo)this.prestamos.get(i)).getId_prestamo() == actualizado.getId_prestamo()) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            this.prestamos.set(posicion, actualizado);
            return actualizado;
        } else {
            return null;
        }
    }

    public Prestamo eliminar(int id) {
        Prestamo p = this.buscarPorId(id);
        if (p != null) {
            this.prestamos.remove(p);
        }

        return p;
    }

    public PrestamoRepository() {
        this.prestamos.add(new Prestamo(1, 1, "12345678-9", LocalDate.now(), (LocalDate)null, 7, 0));
    }
}
