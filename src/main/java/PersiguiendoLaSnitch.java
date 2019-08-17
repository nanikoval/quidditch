public class PersiguiendoLaSnitch implements Accion {
    public void juega(Buscador buscador){
        if (buscador.getKilometrosRecorridos()==5000){
            buscador.setAccion(new AtrapaLaSnitch());
        }
    }
}
