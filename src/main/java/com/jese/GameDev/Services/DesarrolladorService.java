package com.jese.GameDev.Services;

import com.jese.GameDev.Models.Desarrollador;
import java.util.List;

public interface DesarrolladorService {

    Desarrollador crearDesarrollador(Desarrollador desarrollador);

    void asignarDesarrolladorAJuego(int idDev, int idJuego);

    List<Desarrollador> listarDesarrolladoresDeUnJuego(int id);
}
