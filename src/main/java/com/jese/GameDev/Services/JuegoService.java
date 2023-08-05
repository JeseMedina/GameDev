package com.jese.GameDev.Services;

import com.jese.GameDev.Models.Juego;
import java.util.List;

public interface JuegoService {
    Juego crearJuego(Juego juego);
    List<Juego> listarJuegos();
    List<Juego> listarJuegosConFechaVencida();
}