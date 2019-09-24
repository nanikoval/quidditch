package app.model;

import java.util.Calendar;

public class Nimbus extends Escoba {
    private Double porcentajeDeSalud=0.0;
    private Integer añosDeFabricacion=0;

    public Nimbus(String modelo, Double porcentajeDeSalud){
        super(modelo);
        this.setPorcentajeDeSalud(porcentajeDeSalud);
    }


    //1b
    @Override
    public Double velocidadEscoba(){
        return 80- (Calendar.getInstance().get(Calendar.YEAR)-añosDeFabricacion)* getPorcentajeDeSalud();
    }

    //4c
    public void recibeUnGolpe(){
        setPorcentajeDeSalud(getPorcentajeDeSalud() *0.9);
    }

    public Double getPorcentajeDeSalud() {
        return porcentajeDeSalud;
    }

    public void setPorcentajeDeSalud(Double porcentajeDeSalud) {
        this.porcentajeDeSalud = porcentajeDeSalud;
    }
}
