package com.jese.GameDev.Services;

import com.jese.GameDev.Errors.JuegoErrores;
import com.jese.GameDev.Repositories.JuegoRepository;
import com.jese.GameDev.Models.Juego;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class JuegoService {

    private final JuegoRepository juegoRepository;

    @Autowired
    public JuegoService(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    public Juego crearJuego(Juego juego) {
        try {
            boolean existeJuego = juegoRepository.existsByTitulo(juego.getTitulo());
            if (existeJuego) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, JuegoErrores.DUPLICADO);
            }

            return juegoRepository.save(juego);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, JuegoErrores.CREACION, e);
        }
    }

    public List<Juego> listarJuegos() {
        return juegoRepository.findAll();
    }

    public List<Juego> listarJuegosConFechaVencida() {
        LocalDate fechaActual = LocalDate.now();
        return juegoRepository.findByFechaLanzamientoBefore(fechaActual);
    }
}
