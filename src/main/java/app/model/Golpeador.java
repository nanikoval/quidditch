package app.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Golpeador extends Jugador {
    private Double punteria;
    private Double fuerza;

    public Golpeador(Equipo equipo, Double skill, Double peso, Escoba escoba, Double nivelDeReflejos, Double punteria, Double fuerza){
        super(equipo, skill, peso , escoba, nivelDeReflejos);
        this.punteria=punteria;
        this.fuerza=fuerza;

    }

    //1c
    public Double habilidadJugador(){
        return super.habilidadJugador()+punteria+fuerza;
    }

    //4a
    public Boolean puedeBloquearA(Jugador jugador){
        return this.esGroso()==true;
    }

    //4b no es util golpear golpeadores:
    public Boolean esBlancoUtil(){
        return false;
    }

    List<Integer> rangoGolpeador = IntStream.range(1, 10).boxed().collect(Collectors.toList());

    public int getRandomElement(List<Integer> rangoGolpeador)
    {
        Random rand = new Random();
        return rangoGolpeador.get(rand.nextInt(rangoGolpeador.size()));
    }

    public void golpeaConUnaBludgerA(Jugador jugador){
        if(this.punteria>jugador.nivelDeReflejos){
            jugador.esGolpeadoPorUnaBludger();
        }else if (getRandomElement(rangoGolpeador)>=8){
            jugador.esGolpeadoPorUnaBludger();
        }
        skill=skill+1;

    }

    public void setSkill(Double skill) {
        this.skill = skill;
    }

    public Double getSkill() {
        return skill;
    }

    public void setPunteria(Double punteria) {
        this.punteria = punteria;
    }

    public void juega(){
    }
}
