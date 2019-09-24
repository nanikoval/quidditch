package app.model;

public abstract class Escoba {
    protected Integer velocidadDefault=0;
    protected String modelo;

    public Escoba(String modelo){
        this.modelo=modelo;
    }

    public Integer getVelocidadDefault() {
        return velocidadDefault;
    }

    //1b
    public abstract Double velocidadEscoba();

    //4c su escoba recibe un golpe:
    public abstract void recibeUnGolpe();

}
