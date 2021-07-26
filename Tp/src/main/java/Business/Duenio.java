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
    public Duenio(String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDocumento, int numeroDocumento, List<notificarStrategy> formaNotificacion,List<Contacto> contactos, Usuario usuario) {
        super(nombre, apellido, telefono, fechaNacimiento, tipoDocumento, numeroDocumento, formaNotificacion, contactos);
        usuario = usuario;
    }


    public void agregarMascota(Mascota unaMascota){
        mascotas.add(unaMascota);
    }



}
