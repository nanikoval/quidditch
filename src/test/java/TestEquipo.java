import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestEquipo {

    private Equipo equipo1;
    private Equipo equipo2;
    private List<Jugador> jugadores;
    private Jugador j1;
    private Jugador j2;


    @BeforeEach
    void setUp() {
        equipo1 = new Equipo();
        equipo2 = new Equipo();
        jugadores = new ArrayList<>();
        j1 = mock(Jugador.class);
        j2 = mock(Jugador.class);

        jugadores.add(j1);
        jugadores.add(j2);
        equipo1.setJugadores(jugadores);
    }

    @Test
    void tieneUnJugadorEstrella(){
        when(j1.esJugadorEstrellaContra(eq(equipo2))).thenReturn(true);
        assertTrue(equipo1.tieneUnJugadorEstrella(equipo2));
    }

    @Test
    void promedioEquipo(){
        when(j1.habilidadJugador()).thenReturn(300.0);
        when(j2.habilidadJugador()).thenReturn(300.0);
        assertEquals(equipo1.promedioEquipo(),300.0);
    }

    @Test
    void elEquipoMeteGol(){
        equipo1.meteGol();
        assertEquals(equipo1.getPuntos(), 10);
    }

    @Test
    void ningunoDelEquipoTieneLaQuaffle(){
        when(j1.tieneLaQuaffle()).thenReturn(false);
        when(j2.tieneLaQuaffle()).thenReturn(false);
        assertTrue(equipo1.noTieneLaQuaffle());
    }

    @Test
    void unoDelEquipoAtrapoLaSnitch(){
        equipo1.atrapoLaSnitch();
        assertEquals(equipo1.getPuntos(),150);
    }



}