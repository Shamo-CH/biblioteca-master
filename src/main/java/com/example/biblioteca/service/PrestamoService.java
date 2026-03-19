package com.example.biblioteca.service;

import com.example.biblioteca.model.Prestamo;
import com.example.biblioteca.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository repository;

    public List<Prestamo> listarTodos() {
        return repository.obtenerTodos();
    }

    public Prestamo buscarId(int id) {
        return repository.buscarPorId(id);
    }

    public Prestamo crear(Prestamo prestamo) {
        // Aquí podrías poner lógica, como validar que el libro exista
        return repository.guardar(prestamo);
    }

    public Prestamo actualizar(int id, Prestamo p) {
        p.setId_prestamo(id);
        return repository.actualizar(p);
    }

    public void eliminar(int id) {
        repository.eliminar(id);
    }
}