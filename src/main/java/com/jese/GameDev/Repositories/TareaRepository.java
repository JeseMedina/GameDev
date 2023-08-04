package com.jese.GameDev.Repositories;

import com.jese.GameDev.Models.EstadoTarea;
import com.jese.GameDev.Models.Tarea;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    List<Tarea> findByDesarrolladorId(int desarrolladorId);

    List<Tarea> findByEstado(EstadoTarea estado);

    List<Tarea> findByJuegoId(int juegoId);

//    List<Tarea> findByFechaLimiteBeforeAndEstado(LocalDate fechaLimite, EstadoTarea estado);
    
    @Query(value = "SELECT * FROM Tareas t WHERE t.fecha_limite < CURRENT_DATE AND t.estado != 2", nativeQuery = true)
    List<Tarea> findTareasVencidasNoCompletadas();
}
