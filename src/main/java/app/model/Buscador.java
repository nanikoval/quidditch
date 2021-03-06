package app.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Buscador extends Jugador {
    private Double nivelDeVision;
    private Double kilometrosRecorridos=0.0;
    private Integer turnosContinuos=0;
    private Boolean aturdido=true;
    private Accion accion=new BuscandoLaSnitch();

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public Accion getAccion() {
        return accion;
    }

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

    public void setKilometrosRecorridos(Double kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }


    public void incrementaSkill(){
        skill=skill+10;
    }

    public Boolean esBlancoUtil(){
        return this.accion==new PersiguiendoLaSnitch()||kilometrosRecorridos>4000;    }

    //4c si es golpeadoPorUnaBludger() reinicia la busqueda
    public void esGolpeadoPorUnaBludger(){
        super.esGolpeadoPorUnaBludger();
        this.reiniciaLaBusqueda();
        turnosContinuos=0;
        aturdido=true;
    }
    public void reiniciaLaBusqueda(){
        kilometrosRecorridos=0.0;
    }

    public Double kmsRecorridosPorTurno() {
        return this.velocidadJugador()/1.6;
    }

    public void juega(){
        this.getAccion().juega(this);
        turnosContinuos=turnosContinuos+1;
        aturdido=false;
        kilometrosRecorridos = kilometrosRecorridos + kmsRecorridosPorTurno();
    }

    public void setTurnosContinuos(Integer turnosContinuos) {
        this.turnosContinuos = turnosContinuos;
    }

    public Double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public Boolean estaAturdido(){
        return aturdido==true;
    }




}

