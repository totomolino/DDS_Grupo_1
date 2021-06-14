package Business;

import Notificar.notificarStrategy;

import java.util.ArrayList;
import java.util.List;

public class Contacto extends Persona{

    public Contacto(String nombre, String apellido, String telefono, List<notificarStrategy> formaNotificacion, TipoDeUsuario tipoDeUsuario, String usuario, String contrasenia, String email) {
        super(nombre, apellido, telefono, formaNotificacion, tipoDeUsuario, usuario, contrasenia, email);
    }
}
