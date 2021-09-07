package tests;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import seguridad.register;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class registerTest {

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

}