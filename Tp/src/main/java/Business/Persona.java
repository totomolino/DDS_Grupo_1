package Business;

import Notificar.notificarStrategy;

import java.util.ArrayList;
import java.util.List;

public class Persona extends Usuario {
    String nombre;
    String apellido;
    String telefono;
    List<notificarStrategy> formaNotificacion;

    public Persona(String nombre, String apellido, String telefono, List<notificarStrategy> formaNotificacion, TipoDeUsuario tipoDeUsuario, String usuario, String contrasenia, String email) {
        super(tipoDeUsuario, usuario, contrasenia, email);
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.formaNotificacion = formaNotificacion;
    }

//formaNOtificacion: [WHATSAPP, EMAIL, SMS]
    public void serNotificado(){

        for(int i = 0 ; i < formaNotificacion.size() ; i++){

            formaNotificacion.get(i).serNotificado(this);

        }
    }

    public String getTelefono() {
        return telefono;
    }


}
