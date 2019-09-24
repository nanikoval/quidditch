package app.service;

import app.model.Equipo;
import app.persistence.EquipoStorage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {
    private List<Equipo> equipos;

    private EquipoStorage equipoStorage;
    public EquipoService(EquipoStorage equipoStorage){
        this.equipoStorage=equipoStorage;
    }

    public List<Equipo> getEquipos(){
        equipos=equipoStorage.equipos();
        return equipos;
    }
}
