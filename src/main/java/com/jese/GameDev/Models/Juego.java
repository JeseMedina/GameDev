package com.jese.GameDev.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "juegos")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaLanzamiento;

    @OneToMany(mappedBy = "juego")
    @JsonIgnore
    private List<Desarrollador> desarrolladores;

    @OneToMany(mappedBy = "juego")
    @JsonIgnore
    private List<Tarea> tareas;
    
    public Juego(int id) {
        this.id = id;
    }
}
