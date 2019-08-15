import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buscador extends Jugador {
    private Double nivelDeVision;
    private Integer kilometrosRecorridos=0;
    private Integer turnosContinuos=0;
    private Boolean aturdido=true;
    private String accion="persiguiendo la snitch";

    public Integer getTurnosContinuos() {
        return turnosContinuos;
    }

    public Buscador(Equipo equipo, Double skill, Double peso, Escoba escoba, Double nivelDeReflejos,
                    Double nivelDeVision) {
        super(equipo, skill, peso, escoba, nivelDeReflejos);
        this.nivelDeVision = nivelDeVision;
    }

    //1c
    public Double habilidadJugador(){
        return super.habilidadJugador()+nivelDeReflejos*nivelDeVision;
    }

    //4a
    public Boolean puedeBloquearA(Jugador jugador){
        return false;
    }

    /*3 Si el buscador está ​buscando la snitch​, debe hacer un random entre 1 y 1.000 y si el número obtenido es menor a su
     habilidad + la cantidad de turnos continuos buscando entonces encontró la snitch.*/
    List<Integer> rangoBuscador = IntStream.range(1,1000).boxed().collect(Collectors.toList());

    public int getRandomElement(List<Integer> rangoBuscador)
    {
        Random rand = new Random();
        return rangoBuscador.get(rand.nextInt(rangoBuscador.size()));
    }

    public Boolean encontroLaSnitch(){
        return getRandomElement(rangoBuscador)< super.habilidadJugador()+getTurnosContinuos();
    }

    /*3 Si está ​persiguiendo la snitch​, debe recorrer 5.000 kms para poder atraparla. En cada turno recorre una cantidad
    de kms igual a su velocidad / 1,6. Una vez que la atrapó, aumenta sus skills 10 puntos y su equipo gana 150 puntos.*/

    public Boolean persiguiendoLaSnitch(){
        return kilometrosRecorridos==5000;
    }

    public void setKilometrosRecorridos(Integer kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public void atrapoLaSnitch(){
        skill=skill+10;
        equipo.atrapoLaSnitch();

    }

    public Boolean esBlancoUtil(){
        return persiguiendoLaSnitch()||kilometrosRecorridos>4000;    }

    //4c si es golpeadoPorUnaBludger() reinicia la busqueda
    public void esGolpeadoPorUnaBludger(){
        super.esGolpeadoPorUnaBludger();
        this.reiniciaLaBusqueda();
        turnosContinuos=0;
        aturdido=true;
    }
    public void reiniciaLaBusqueda(){
        kilometrosRecorridos=0;
    }

    public void juega(){
        this.persiguiendoLaSnitch();
        turnosContinuos=turnosContinuos+1;
        aturdido=false;
        accion="buscando la snitch";

    }

    public void setTurnosContinuos(Integer turnosContinuos) {
        this.turnosContinuos = turnosContinuos;
    }

    public Integer getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public Boolean estaAturdido(){
        return aturdido==true;
    }
}

