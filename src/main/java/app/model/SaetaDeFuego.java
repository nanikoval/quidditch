package app.model;

public class SaetaDeFuego extends Escoba {

    public SaetaDeFuego(String modelo){
        super(modelo);
    }

    //1b
    public Double velocidadEscoba(){
        return 100.0;
    }

    public void recibeUnGolpe(){}
}
