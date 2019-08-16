public class AtrapaLaSnitch implements Accion{

    private Equipo equipo;

    public void juega(Buscador buscador){
        buscador.incrementaSkill();
        equipo.atrapoLaSnitch();

    }


}
