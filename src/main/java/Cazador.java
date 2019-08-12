public class Cazador extends Jugador {
    private Double punteria;
    private Double fuerza;


    public void setFuerza(Double fuerza) {
        this.fuerza = fuerza;
    }

    public void setPunteria(Double punteria) {
        this.punteria = punteria;
    }

    public Cazador(Equipo equipo, Double skill, Double peso, Escoba escoba,Double nivelDeReflejos, Double punteria,
                   Double fuerza){
        super(equipo, skill, peso,escoba, nivelDeReflejos);
        this.punteria=punteria;
        this.fuerza=fuerza;
    }


    //1c
    public Double habilidadJugador(){
        return super.habilidadJugador()+punteria*fuerza;
    }

    //4a
    public Boolean puedeBloquearA(Jugador jugador){
        return equipo.getJugadores().stream().anyMatch(j->j.lePasaElTrapoA(this));
    }

    //3 Meter gol (...) el cazador gana 5 puntos de skills
    public void meteGol(){
        skill=skill+5;
    }

    //3 Si el tiro se interrumpe por un bloqueo, el cazador pierde 2 puntos de skills
    public void esBloqueadoX(Jugador jugador){
        skill=skill-2;
    }

    //4b es blanco util si tiene la quaffle:
    public Boolean tieneLaQuaffle(){
        return tieneLaQuaffle;
    }

    public Boolean esBlancoUtil(){
        return this.tieneLaQuaffle();
    }


    //4c  los ​cazadores, si tenían la quaffle, ​la pierden​
    public void esGolpeadoPorUnaBludger(){
        super.esGolpeadoPorUnaBludger();
        this.pierdeLaQuaffle();
    }

    public void juega(){
        this.pierdeLaQuaffle();
    }
}