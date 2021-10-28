package Business;

import Notificar.notificarStrategy;

import java.util.ArrayList;
import java.util.List;

public class Duenio extends Persona {

    List<Mascota> mascotas = new ArrayList<>();

/*
    public Duenio(String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDocumento, int numeroDocumento, List<notificarStrategy> formaNotificacion, String nombreUsuario, String email, String contrasenia) {
        super(nombre, apellido, telefono, fechaNacimiento, tipoDocumento, numeroDocumento, formaNotificacion);
        usuario = new Usuario(TipoDeUsuario.DUENIO, nombre, contrasenia, email);
    }*/
    public Duenio(Long id, String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDocumento, int numeroDocumento, List<notificarStrategy> formaNotificacion,List<Contacto> contactos, Usuario usuario) {
        super(id, nombre, apellido, telefono, fechaNacimiento, tipoDocumento, numeroDocumento, formaNotificacion, contactos);
        this.usuario = usuario;
    }

    public void agregarMascota(Mascota unaMascota){
        mascotas.add(unaMascota);
    }


    public boolean tieneXUsuario(String unUsuario) {
        return usuario.nombre.equals(unUsuario);
    }

    public void serNotificadoAdopcion(Adoptante adoptante) {
        for(int i = 0 ; i < formaNotificacion.size() ; i++) {
            formaNotificacion.get(i).notificarAdopcion(usuario.email, telefono, adoptante);
        }

        for (Contacto c : contactos ) {
            c.notificarAdopcion(adoptante);
        }

    }

    public void notificarMascotaEncontrada(Mascota mascota){

        for(int i = 0 ; i < formaNotificacion.size() ; i++) {
            formaNotificacion.get(i).notificarMascotaEncontrada(usuario.email, telefono, mascota);
        }

        for (Contacto c : contactos ) {
            c.notifcarMascotaEncontrada(mascota);
        }
    }
}
