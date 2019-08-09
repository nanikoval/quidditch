import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private Integer puntos=0;
    private List<Jugador> jugadores=new ArrayList<>();

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    //para no usar reduce y usar solo sum() hago mapToInt en lugar de map
    public Double promedioEquipo(){
        return getJugadores().stream().mapToDouble(jugador -> jugador.habilidadJugador()).sum()/(getJugadores().size());
    }

    /*2c Si un equipo tiene un jugador estrella para jugar contra otro equipo. Un jugador es
    estrella si le pasa el trapo a todos los jugadores del equipo contrario.*/
    public Boolean tieneUnJugadorEstrella (Equipo equipo){
        return this.getJugadores().stream().anyMatch(jugador -> jugador.esJugadorEstrellaContra(equipo));
    }

    //3 El equipo gana 10 puntos por meter gol
    public void meteGol(){
        puntos=puntos+10;
    }

    //atrapoLaSnitch
    public void atrapoLaSnitch(){
        puntos=puntos+150;
    }

    public Boolean noTieneLaQuaffle(){
        return this.getJugadores().stream().anyMatch(jugador->!jugador.tieneLaQuaffle());
    }


    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Integer getPuntos() {
        return puntos;
    }
}
