package app.controller;

import app.model.Equipo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import app.service.EquipoService;

import java.util.List;

@RestController
public class EquipoController {
    private EquipoService equipoService;
    public EquipoController(EquipoService equipoService){
        this.equipoService=equipoService;
    }

    @GetMapping("/equipos")
    public List<Equipo> equipo(){
        return equipoService.getEquipos();
    }
}
