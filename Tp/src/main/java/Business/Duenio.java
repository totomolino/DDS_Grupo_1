package Business;

import Notificar.notificarStrategy;

import java.util.ArrayList;
import java.util.List;

public class Duenio extends Persona {

    String fechaNacimiento;
    String tipoDocumento;
    int numeroDocumento;
    List<Mascota> mascotas = new ArrayList<>();

    public Duenio(TipoDeUsuario tipoDeUsuario, String contrasenia,String usuario,  String email, String nombre, String apellido, String telefono, List<notificarStrategy> formaNotificacion, String fechaNacimiento, String tipoDocumento, int numeroDocumento, List<Mascota> mascotas) {

        super(nombre, apellido, telefono, formaNotificacion, tipoDeUsuario, usuario, contrasenia, email);
        this.formaNotificacion = formaNotificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.mascotas = mascotas;
    }






    public void agregarMascota(Mascota unaMascota){
        mascotas.add(unaMascota);
    }



}
