package com.jese.GameDev.Models;

public enum EstadoTarea {
    PENDIENTE("Pendiente"),
    EN_PROGRESO("En progreso"),
    COMPLETADA("Completada");

    private final String descripcion;

    EstadoTarea(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}