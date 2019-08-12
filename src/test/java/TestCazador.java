import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class TestCazador {
    private Cazador cazador;
    private Guardian guardian;
    private Equipo equipo;
    private SaetaDeFuego saetaDeFuego;




    @BeforeEach
    void setUp(){
        equipo= new Equipo();
        saetaDeFuego=new SaetaDeFuego("Saeta1500");
        cazador=new Cazador(equipo, 20.0,40.0, saetaDeFuego, 45.0, 30.0, 25.0);
        guardian=new Guardian(equipo, 30.0, 45.0, saetaDeFuego, 36.0, 45.0);

    }

    @Test
    void elCazadorMeteGol(){
        cazador.meteGol();
        assertEquals(cazador.getSkill(),25.0);
    }

    @Test
    void elCazadorEsBloqueadoPorUnGolpeador(){
        cazador.esBloqueadoX(guardian);
        assertEquals(cazador.getSkill(), 18.0);
    }

    @Test
    void elCazadorEsBlancoUtil(){
        cazador.tieneLaQuaffle();
        assertTrue(cazador.esBlancoUtil());
    }

    @Test
    void elGolpeadorPorUnaBludger(){
        cazador.esGolpeadoPorUnaBludger();
        assertFalse(cazador.tieneLaQuaffle());
    }



}
