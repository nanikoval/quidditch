import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;



public class TestGuardian {
    private Guardian guardian;
    private Equipo equipo;
    private Nimbus nimbus;

    @BeforeEach
    void setUp(){
        equipo=new Equipo();
        nimbus=new Nimbus("Nimbus2200", 80.0);
        guardian=new Guardian(equipo, 30.0,35.0,nimbus,40.0,45.0);
    }

    @Test
    void elGuardianNoEsBlancoUtil(){
        assertFalse(equipo.noTieneLaQuaffle());
    }
}
