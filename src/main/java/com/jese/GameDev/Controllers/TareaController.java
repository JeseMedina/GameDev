package com.jese.GameDev.Controllers;

import com.jese.GameDev.Models.EstadoTarea;
import com.jese.GameDev.Services.Impl.TareaServiceImpl;
import com.jese.GameDev.Models.Tarea;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tarea")
public class TareaController {
    
    @Autowired
    TareaServiceImpl tareaService;
    
    @PostMapping
    @ResponseBody
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaService.crearTarea(tarea);
    }

    @PutMapping("/{idTarea}/estado/{nuevoEstado}")
    @ResponseBody
    public Tarea modificarTareaEstado(@PathVariable int idTarea, @PathVariable EstadoTarea nuevoEstado) {
        return tareaService.modificarTareaEstado(idTarea, nuevoEstado);
    }

    @GetMapping("/dev/{idDev}")
    @ResponseBody
    public List<Tarea> listarTareasDev(@PathVariable int idDev) {
        return tareaService.listarTareasDev(idDev);
    }

    @GetMapping("/estado/{estado}")
    @ResponseBody
    public List<Tarea> listarTareasPorEstado(@PathVariable EstadoTarea estado) {
        return tareaService.listarTareasPorEstado(estado);
    }

    @GetMapping("/juegos/{idJuego}")
    @ResponseBody
    public List<Tarea> listarTareasPorJuego(@PathVariable int idJuego) {
        return tareaService.listarTareasPorJuego(idJuego);
    }

    @GetMapping("/vencidas")
    @ResponseBody
    public List<Tarea> listarTareasVencidas() {
        return tareaService.listarTareasVencidas();
    }
}
