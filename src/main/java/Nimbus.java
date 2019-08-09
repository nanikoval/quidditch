import java.util.Calendar;

public class Nimbus extends Escoba {
    protected Double porcentajeDeSalud=0.0;
    private Integer añosDeFabricacion=0;

    public Nimbus(String modelo, Double porcentajeDeSalud){
        super(modelo);
        this.porcentajeDeSalud=porcentajeDeSalud;
    }


    //1b
    @Override
    public Double velocidadEscoba(){
        return 80- (Calendar.getInstance().get(Calendar.YEAR)-añosDeFabricacion)*porcentajeDeSalud;
    }

    //4c
    public void recibeUnGolpe(){
        porcentajeDeSalud=porcentajeDeSalud*0.9;
    }
}
