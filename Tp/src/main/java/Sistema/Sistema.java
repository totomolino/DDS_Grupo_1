package Sistema;

import Business.Duenio;
import Business.Mascota;
import Business.Organizacion;
import Business.Usuario;
import seguridad.register;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    List<Organizacion> listaDeOrganizaciones = new ArrayList<>();
    List<Usuario> listaDeUsuarios = new ArrayList<>();


    public static void validarContrasenia(String contrasenia, String usuario) throws FileNotFoundException {
        register.validarContrasenia(contrasenia, usuario);
    }
 /*   public void crearDuenio() {
        Duenio duenio = new Duenio();
    }*/
    public void crearAdmin() {

    }



}
