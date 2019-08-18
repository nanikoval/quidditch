public class BuscandoLaSnitch implements Accion {
  
    public void juega(Buscador buscador){
        buscador.encontroLaSnitch();
        buscador.setAccion(new PersiguiendoLaSnitch());
    }
}
