package com.jese.GameDev.Services;

import com.jese.GameDev.Models.Tarea;
import com.jese.GameDev.Models.EstadoTarea;

import java.util.List;

public interface TareaService {
    Tarea crearTarea(Tarea tarea);
    Tarea modificarTareaEstado(int idTarea, EstadoTarea nuevoEstado);
    List<Tarea> listarTareasDev(int idDev);
    List<Tarea> listarTareasPorEstado(EstadoTarea estado);
    List<Tarea> listarTareasPorJuego(int idJuego);
    List<Tarea> listarTareasVencidas();
}