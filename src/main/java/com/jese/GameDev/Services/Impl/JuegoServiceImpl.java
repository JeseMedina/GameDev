package com.jese.GameDev.Services.Impl;

import com.jese.GameDev.Errors.JuegoErrores;
import com.jese.GameDev.Repositories.JuegoRepository;
import com.jese.GameDev.Models.Juego;
import com.jese.GameDev.Services.JuegoService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class JuegoServiceImpl implements JuegoService {

    private final JuegoRepository juegoRepository;

    @Autowired
    public JuegoServiceImpl(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @Override
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

    @Override
    public List<Juego> listarJuegos() {
        return juegoRepository.findAll();
    }

    @Override
    public List<Juego> listarJuegosConFechaVencida() {
        LocalDate fechaActual = LocalDate.now();
        return juegoRepository.findByFechaLanzamientoBefore(fechaActual);
    }
}
