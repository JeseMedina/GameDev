package com.jese.GameDev.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String descripcion;
    private LocalDate fechaLimite;
    private EstadoTarea estado;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "desarrollador_id")
    private Desarrollador desarrollador;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "juego_id")
    private Juego juego;

}
