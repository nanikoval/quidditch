package app.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Guardian extends Jugador {
    private Double fuerza;

    public Guardian(Equipo equipo, Double skill, Double peso, Escoba escoba, Double nivelDeReflejos, Double fuerza){
        super(equipo, skill, peso, escoba, nivelDeReflejos);
        this.fuerza=fuerza;

    }

    //1c
    public Double habilidadJugador(){
        return super.habilidadJugador()+nivelDeReflejos+fuerza;
    }

    //*******************************************************************************
    List<Integer> rangoGuardian = IntStream.range(1, 3).boxed().collect(Collectors.toList());

    public int getRandomElement(List<Integer> rangoGuardian)
    {
        Random rand = new Random();
        return rangoGuardian.get(rand.nextInt(rangoGuardian.size()));
    }

    //4a
    public Boolean puedeBloquearA(Jugador jugador){
        return getRandomElement(rangoGuardian)==3;
    }
    //*******************************************************************************

    //4b si su equipo NO tiene la Quaffle:
    public Boolean esBlancoUtil(){
        return equipo.noTieneLaQuaffle();
    }

    public void juega(){}
}
