package com.jese.GameDev.Services;

import com.jese.GameDev.Errors.TareaErrores;
import com.jese.GameDev.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.jese.GameDev.Models.Tarea;
import com.jese.GameDev.Models.EstadoTarea;
import java.time.LocalDate;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepo;

    public Tarea crearTarea(Tarea tarea) {
        try {
            return tareaRepo.save(tarea);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, TareaErrores.CREACION, e);
        }
    }

    public Tarea modificarTareaEstado(int idTarea, EstadoTarea nuevoEstado) {
        try {
            Tarea tarea = tareaRepo.findById(idTarea)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada con ID: " + idTarea));

            tarea.setEstado(nuevoEstado);

            return tareaRepo.save(tarea);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, TareaErrores.MODIFICAR_ESTADO, e);
        }
    }

    public List<Tarea> listarTareasDev(int idDev) {
        try {
            return tareaRepo.findByDesarrolladorId(idDev);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, TareaErrores.LISTADO, e);
        }
    }

    public List<Tarea> listarTareasPorEstado(EstadoTarea estado) {
        try {
            return tareaRepo.findByEstado(estado);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, TareaErrores.LISTADO, e);
        }
    }

    public List<Tarea> listarTareasPorJuego(int idJuego) {
        try {
            return tareaRepo.findByJuegoId(idJuego);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, TareaErrores.LISTADO, e);
        }
    }

    public List<Tarea> listarTareasVencidas() {
        try {
            return tareaRepo.findTareasVencidasNoCompletadas();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, TareaErrores.LISTADO, e);
        }
    }
}
