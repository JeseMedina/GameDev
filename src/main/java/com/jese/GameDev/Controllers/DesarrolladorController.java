package com.jese.GameDev.Controllers;

import com.jese.GameDev.Services.DesarrolladorService;
import com.jese.GameDev.Models.Desarrollador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/desarrolladores")
public class DesarrolladorController {

    @Autowired
    DesarrolladorService desarrolladorService;

    @PostMapping
    @ResponseBody
    public Desarrollador crearDesarrollador(@RequestBody Desarrollador desarrollador) {
        return desarrolladorService.crearDesarrollador(desarrollador);
    }

    @PostMapping("/{idDev}/juegos/{idJuego}")
    @ResponseBody
    public void asignarDesarrolladorAJuego(@PathVariable int idDev, @PathVariable int idJuego) {
        desarrolladorService.asignarDesarrolladorAJuego(idDev, idJuego);
    }

    @GetMapping("/juegos/{id}")
    @ResponseBody
    public List<Desarrollador> listarDesarrolladoresDeUnJuego(@PathVariable int id) {
        return desarrolladorService.listarDesarrolladoresDeUnJuego(id);
    }
}
