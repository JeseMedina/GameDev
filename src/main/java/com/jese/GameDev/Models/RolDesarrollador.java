package com.jese.GameDev.Models;

public enum RolDesarrollador {
    DEV("Desarrollador"),
    QA("Tester"),
    DEV_OPS("Operaciones de Desarrollo");

    private final String descripcion;

    RolDesarrollador(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}