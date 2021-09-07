package tests;

import Business.services.apiHogares.apiHogares;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;

import static org.junit.Assert.*;

public class apiHogaresTest {

    @Test
    @DisplayName("Listado de hogares de la api")
    public void listadoDeHogares() throws IOException {
        apiHogares api = apiHogares.getInstancia();
        assertTrue(api.listadoDeHogaresPorOffset(1).size() > 0 );
    }
}