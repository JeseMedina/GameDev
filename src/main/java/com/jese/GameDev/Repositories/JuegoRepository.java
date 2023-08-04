package com.jese.GameDev.Repositories;

import com.jese.GameDev.Models.Juego;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer>{
    
    public boolean existsByTitulo(String titulo);
    public List<Juego> findByFechaLanzamientoBefore(LocalDate fechaActual);
}
