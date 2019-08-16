import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBuscador {
    private Equipo equipo;
    private Buscador buscador;
    private Nimbus nimbus;

    @BeforeEach
    void setUp() {
        equipo = new Equipo();
        nimbus = new Nimbus("Nimbus1000", 70.0);
        buscador = new Buscador(equipo, 10.5, 50.0, nimbus, 45.5, 20.0);
    }

    @Test
    void buscadorJuega(){
        buscador.juega();
        assertEquals(buscador.getTurnosContinuos(), 1);
    }

    @Test
    void buscadorEsGolpeado(){
        buscador.juega();
        buscador.esGolpeadoPorUnaBludger();
        assertEquals(buscador.getTurnosContinuos(),0);
        assertEquals(buscador.getKilometrosRecorridos(), 0);
    }

}
