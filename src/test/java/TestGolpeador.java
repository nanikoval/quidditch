import app.model.Equipo;
import app.model.Golpeador;
import app.model.Guardian;
import app.model.SaetaDeFuego;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestGolpeador {
    private Golpeador golpeador;
    private Guardian guardian;
    private Equipo equipo;
    private SaetaDeFuego saetaDeFuego;

    @BeforeEach
    void setUp(){
        equipo=new Equipo();
        saetaDeFuego=new SaetaDeFuego("Saeta2000");
        golpeador=new Golpeador(equipo, 30.0, 36.0, saetaDeFuego, 35.0,45.0, 50.0);
        guardian=new Guardian(equipo, 25.0, 40.0, saetaDeFuego, 30.0, 40.0);
    }

    @Test
    void elGolpeadorNoPuedeBloquearAlGuardian(){
        golpeador.esGroso();
        assertFalse(golpeador.puedeBloquearA(guardian));
    }

    @Test
    void elGolpeadorGolpeaConUnaBludgerAlGuardian(){
        golpeador.golpeaConUnaBludgerA(guardian);
        assertEquals(golpeador.getSkill().doubleValue(), 31.0);
    }
}
