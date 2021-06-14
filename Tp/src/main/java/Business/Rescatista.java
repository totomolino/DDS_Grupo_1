package Business;

import Notificar.notificarStrategy;

import java.util.ArrayList;
import java.util.List;

public class Rescatista {

    String fechaNacimiento;
    String tipoDocumento;
    int numeroDocumento;
    String nombre;
    String apellido;
    String telefono;
    List<notificarStrategy> formaNotificacion;
    List<Contacto> contactos = new ArrayList<>();

    public Rescatista(String fechaNacimiento, String tipoDocumento, int numeroDocumento, String nombre, String apellido, String telefono, List<notificarStrategy> formaNotificacion, List<Contacto> contactos) {
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.formaNotificacion = formaNotificacion;
        this.contactos = contactos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<notificarStrategy> getFormaNotificacion() {
        return formaNotificacion;
    }

    public void setFormaNotificacion(List<notificarStrategy> formaNotificacion) {
        this.formaNotificacion = formaNotificacion;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }
}
