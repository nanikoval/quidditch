import app.model.Nimbus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNimbus {

    private Nimbus nimbus;

    @Test
    void laNimbusRecibeUnGolpe(){
        nimbus=new Nimbus("Nimbus1100", 100.0);
        nimbus.recibeUnGolpe();
        assertEquals(nimbus.getPorcentajeDeSalud().doubleValue(),90.0);
    }
}
