package com.example.biblioteca.model;

import java.time.LocalDate;

public class Prestamo {
    private int id_prestamo;
    private int id_libro;
    private String run_solicitante;
    private LocalDate fecha_solicitud;
    private LocalDate fecha_entrega;
    private int cantidad_dias;
    private int multas;

    public Prestamo() {
    }

    public Prestamo(int id_prestamo, int id_libro, String run_solicitante, LocalDate fecha_solicitud, LocalDate fecha_entrega, int cantidad_dias, int multas) {
        this.id_prestamo = id_prestamo;
        this.id_libro = id_libro;
        this.run_solicitante = run_solicitante;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_entrega = fecha_entrega;
        this.cantidad_dias = cantidad_dias;
        this.multas = multas;
    }

    public int getId_prestamo() {
        return this.id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_libro() {
        return this.id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getRun_solicitante() {
        return this.run_solicitante;
    }

    public void setRun_solicitante(String run_solicitante) {
        this.run_solicitante = run_solicitante;
    }

    public LocalDate getFecha_solicitud() {
        return this.fecha_solicitud;
    }

    public void setFecha_solicitud(LocalDate fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public LocalDate getFecha_entrega() {
        return this.fecha_entrega;
    }

    public void setFecha_entrega(LocalDate fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getCantidad_dias() {
        return this.cantidad_dias;
    }

    public void setCantidad_dias(int cantidad_dias) {
        this.cantidad_dias = cantidad_dias;
    }

    public int getMultas() {
        return this.multas;
    }

    public void setMultas(int multas) {
        this.multas = multas;
    }
}
