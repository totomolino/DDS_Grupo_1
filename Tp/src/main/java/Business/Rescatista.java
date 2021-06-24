package Business;

import Notificar.notificarStrategy;
import Sistema.Sistema;

import java.util.ArrayList;
import java.util.List;

public class Rescatista extends Persona {

    public Rescatista(String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDocumento, int numeroDocumento, List<notificarStrategy> formaNotificacion, String email, String contrasenia, String nombreUsuario) {
        super(nombre, apellido, telefono, fechaNacimiento, tipoDocumento, numeroDocumento, formaNotificacion);
        usuario = new Usuario(TipoDeUsuario.RESCATISTA,nombreUsuario,contrasenia,email);
    }

    public List<hogarDeTransito> getHogaresDeTransito() {
        Sistema.getHogaresDeTransito();
    }

}
