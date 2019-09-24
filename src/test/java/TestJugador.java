import app.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestJugador {

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
        guardian=new Guardian(equipo, 20.0, 30.0, saetaDeFuego, 45.0, 25.0);
        buscador = new Buscador(equipo, 10.0, 30.0, nimbus, 40.0,35.0);
        cazador=new Cazador(equipo, 10.0, 80.0, nimbus, 35.0, 20.0, 10.0);

        jugadores.add(buscador);
        jugadores.add(cazador);
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
    void buscadorLePasaElTrapoACazador(){
        when(buscador.habilidadJugador()).thenReturn(7.0);
        when(cazador.habilidadJugador()).thenReturn(3.0);
        assertTrue(buscador.lePasaElTrapoA(cazador));
    }

    @Test
    void nivelDeManejoDeEscoba(){
        assertEquals(buscador.nivelDeManejoDeEscoba().doubleValue(), 0.3333333333333333);
    }

    @Test
    void velocidadJugador(){
        assertEquals(guardian.velocidadJugador().doubleValue(), 66.66666666666666);
    }

    @Test
    void habilidadJugador(){
        assertEquals(cazador.habilidadJugador().doubleValue(),210.0);
    }

    @Test
    void buscadorBloqueaAcazador(){
        guardian.bloqueoA(cazador);
        assertEquals(guardian.getSkill().doubleValue(),30.0);
    }

}
