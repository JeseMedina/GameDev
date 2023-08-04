package com.jese.GameDev.Services;

import com.jese.GameDev.Errors.DesarrolladorErrores;
import com.jese.GameDev.Repositories.DesarrolladorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jese.GameDev.Models.Desarrollador;
import com.jese.GameDev.Models.Juego;
import com.jese.GameDev.Repositories.JuegoRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DesarrolladorService {

    private final DesarrolladorRepository desarrolladorRepo;
    private final JuegoRepository juegoRepo;

    @Autowired
    public DesarrolladorService(DesarrolladorRepository desarrolladorRepo, JuegoRepository juegoRepo) {
        this.desarrolladorRepo = desarrolladorRepo;
        this.juegoRepo = juegoRepo;
    }

    public Desarrollador crearDesarrollador(Desarrollador desarrollador) {
        try {
            return desarrolladorRepo.save(desarrollador);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, DesarrolladorErrores.CREACION, e);
        }
    }

    public void asignarDesarrolladorAJuego(int idDev, int idJuego) {
        try {
            Desarrollador desarrollador = desarrolladorRepo.findById(idDev)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Desarrollador no encontrado con ID: " + idDev));

            Juego juego = juegoRepo.findById(idJuego)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Juego no encontrado con ID: " + idJuego));

            juego.getDesarrolladores().add(desarrollador);
            desarrollador.setJuego(juego);

            juegoRepo.save(juego);
            desarrolladorRepo.save(desarrollador);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, DesarrolladorErrores.ASIGNACION, e);
        }
    }

    public List<Desarrollador> listarDesarrolladoresDeUnJuego(int id) {
        try {
            Juego juego = juegoRepo.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Juego no encontrado con ID: " + id));

            List<Desarrollador> desarrolladores = juego.getDesarrolladores();

            return desarrolladores;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, DesarrolladorErrores.LISTADO, e);
        }
    }
}
