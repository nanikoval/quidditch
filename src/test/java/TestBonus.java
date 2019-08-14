import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TestBonus {

    private Jugador jugador;
    private Equipo equipo;
    private Nimbus nimbus;
    private List<Jugador> jugadores;
    private Buscador buscador;
    private Cazador cazador;
    private SaetaDeFuego saetaDeFuego;
    private Guardian guardian;

    @BeforeEach
    void setUp() {

        equipo=mock(Equipo.class);
        jugadores = new ArrayList<>();
        nimbus=mock(Nimbus.class);
        saetaDeFuego=new SaetaDeFuego("Saeta");
        buscador = new Buscador(equipo, 10.0, 30.0, nimbus, 40.0,35.0);

        jugadores.add(buscador);
        equipo.setJugadores(jugadores);
    }
    @Test
    void esGroso(){
        when(buscador.habilidadJugador()).thenReturn(0.3);
        when(equipo.promedioEquipo()).thenReturn(0.6);
        when(nimbus.velocidadEscoba()).thenReturn(10.0);
        when(nimbus.getVelocidadDefault()).thenReturn(0);
        assertTrue(buscador.esGroso());
    }

    @Test
    void buscadorEsGolpeadoPorUnaBludger(){
        buscador.juega();
        buscador.esGolpeadoPorUnaBludger();
        assertEquals(buscador.getTurnosContinuos(),0);
        assertEquals(buscador.getKilometrosRecorridos(), 0);
    }

    @Test
    void elBuscadorDejaDeEstarAturdido(){
        buscador.juega();
        buscador.persiguiendoLaSnitch();//lo vuelve blanco util
        assertFalse(buscador.estaAturdido());
    }


}
