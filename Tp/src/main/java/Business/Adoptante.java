package Business;

import Business.publicaciones.PublicacionDarEnAdopcion;
import Notificar.notificarStrategy;

import java.util.HashMap;
import java.util.List;

public class Adoptante extends Persona{
    List<HashMap<String, String>> comodidades;

    public Adoptante(String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDocumento, int numeroDocumento, List<notificarStrategy> formaNotificacion, List<Contacto> contactos, Usuario usuario) {
        super(nombre, apellido, telefono, fechaNacimiento, tipoDocumento, numeroDocumento, formaNotificacion, contactos);
        this.usuario = usuario;
    }

    public void quieroAdoptar(PublicacionDarEnAdopcion unaPubl) {
        (unaPubl.duenio).serNotificadoAdopcion(this);
    }

}
