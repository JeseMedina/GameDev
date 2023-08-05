package com.jese.GameDev.Controllers;

import com.jese.GameDev.Services.Impl.JuegoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jese.GameDev.Models.Juego;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    private final JuegoServiceImpl juegoService;

    @Autowired
    public JuegoController(JuegoServiceImpl juegoService) {
        this.juegoService = juegoService;
    }

    @PostMapping
    @ResponseBody
    public Juego crearJuego(@RequestBody Juego juego) {
        return juegoService.crearJuego(juego);
    }

    @GetMapping
    public List<Juego> listarJuegos() {
        return juegoService.listarJuegos();
    }

    @GetMapping("/vencidos")
    @ResponseBody
    public List<Juego> listarJuegosConFechaVencida() {
        return juegoService.listarJuegosConFechaVencida();
    }
}
