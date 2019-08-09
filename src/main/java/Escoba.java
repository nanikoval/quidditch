public abstract class Escoba {
    private Integer velocidadDefault=0;
    private String modelo;

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
