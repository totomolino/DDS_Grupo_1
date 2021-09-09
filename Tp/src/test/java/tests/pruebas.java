package tests;

import Business.TipoDeUsuario;
import Business.services.apiHogares.apiHogares;
import Notificar.twilio;
import Sistema.Sistema;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import seguridad.register;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class pruebas {

    @Test
    @DisplayName("Una contrasenia facil no pasa el validador")
    public void esFacil() throws FileNotFoundException {
        assertTrue(register.esFacil("abcde"));
    }
    @Test
    @DisplayName("Una contrasenia con menos de 8 caracteres no pasa ")
    public void validarContraCorta() throws FileNotFoundException {
        assertFalse(register.validarContrasenia("Muyhard", "Adasdasd"));
    }

    @Test
    @DisplayName("Una contrasenia que cumple con todo devuelve true ")
    public void validarContrasenia() throws FileNotFoundException {
        assertTrue(register.validarContrasenia("Muyhard1235", "Adasdasd"));
    }

    @Test
    @DisplayName("Listado de hogares de la api")
    public void listadoDeHogares() throws IOException {
        apiHogares api = apiHogares.getInstancia();
        assertTrue(api.listadoDeHogaresPorOffset(1).size() > 0 );
    }

    @Test
    @DisplayName("Prueba twilio")
    public void pruebaTwilio(){
        try {
            twilio.mandarSMS("+541166070996", "MASCOTA ENCONTRADA");
            twilio.mandarWhatsapp("+5491166070996", "MASCOTA ENCONTRADA");
        }
        catch(Exception e){
            fail("No pudo mandar el mensaje");
        }
    }

}