public abstract class Jugador {
    protected Double skill;
    protected Double peso;
    protected Escoba escoba;
    protected Equipo equipo;
    protected Double nivelDeReflejos;
    protected Boolean tieneLaQuaffle=true;

    public Boolean tieneLaQuaffle(){
        return tieneLaQuaffle=true;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Jugador(Equipo equipo, Double skill, Double peso, Escoba escoba, Double nivelDeReflejos){
        this.equipo=equipo;
        this.skill=skill;
        this.peso=peso;
        this.escoba=escoba;
        this.nivelDeReflejos=nivelDeReflejos;
    }

    /*1a) Saber el nivel de manejo de escoba de un jugador. Esto se calcula como los skills del
    jugador / su peso*/
    public Double nivelDeManejoDeEscoba(){
        return skill/peso;
    }

    /*1b) Saber la velocidad de un jugador, que es la velocidad de la escoba que use multiplicado
    por su nivel de manejo de escoba*/
    public Double velocidadJugador(){
        return escoba.velocidadEscoba()*this.nivelDeManejoDeEscoba();
    }

    /*1c Saber la habilidad de un jugador. Como cada jugador tiene un entrenamiento acorde a
    su posición en el campo, su habilidad se calcula de formas diferentes:*/
    public Double habilidadJugador(){
        return this.velocidadJugador()+skill;
    }

    /*2a Si un jugador le pasa el trapo a otro; esto sucede si es por lo menos el doble de
    habilidoso que el otro jugador*/
    public Boolean lePasaElTrapoA(Jugador jugador){
        return this.habilidadJugador()>=2*jugador.habilidadJugador();
    }

    /*2b Si un jugador es groso, que se cumple si su habilidad es mayor al promedio de su
    equipo y su velocidad mayor a un valor arbitrario que a medida que el mercado de
    escobas mejora se actualiza para todos por igual*/
    public Boolean esGroso(){
        return (this.habilidadJugador()>equipo.promedioEquipo())&&this.velocidadJugador()>escoba.getVelocidadDefault();
    }

    /*2c Si un equipo tiene un jugador estrella para jugar contra otro equipo. Un jugador es
    estrella si le pasa el trapo a todos los jugadores del equipo contrario.*/

    public Boolean esJugadorEstrellaContra (Equipo equipo){
        //que a cada jugador this le pase el trapo
        return equipo.getJugadores().stream().allMatch(j -> this.lePasaElTrapoA(j));
    }

    //3 el que bloqueó gana 10
    public void bloqueoA(Jugador jugador){
        skill=skill+10.0;
    }

    //4b Saber si un jugador es un blanco util:
    public abstract Boolean esBlancoUtil();


    //Hacer que un jugador ​sea golpeado por una bludger:
    public void esGolpeadoPorUnaBludger(){
        skill=skill-2;
        escoba.recibeUnGolpe();
    }

    public void setNivelDeReflejos(Double nivelDeReflejos) {
        this.nivelDeReflejos = nivelDeReflejos;
    }

    public Double getSkill() {
        return skill;
    }

    public abstract void juega();
}
