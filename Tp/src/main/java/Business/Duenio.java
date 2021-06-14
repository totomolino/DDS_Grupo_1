package Business;

import Notificar.notificarStrategy;

import java.util.ArrayList;
import java.util.List;

public class Duenio extends Persona {

    String fechaNacimiento;
    String tipoDocumento;
    int numeroDocumento;
    List<Mascota> mascotas = new ArrayList<>();
    List<Contacto> contactos = new ArrayList<>();

    public Duenio(TipoDeUsuario tipoDeUsuario, String contrasenia,String usuario,  String email, String nombre, String apellido, String telefono, List<notificarStrategy> formaNotificacion, String fechaNacimiento, String tipoDocumento, int numeroDocumento, List<Mascota> mascotas, List<Contacto> contactos) {

        super(nombre, apellido, telefono, formaNotificacion, tipoDeUsuario, usuario, contrasenia, email);
        this.formaNotificacion = formaNotificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.mascotas = mascotas;
        this.contactos = contactos;
    }



    public void agregarContacto(Contacto unContacto){
        contactos.add(unContacto);
    }


    public void agregarMascota(Mascota unaMascota){
        mascotas.add(unaMascota);
    }



}
