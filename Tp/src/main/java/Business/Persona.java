package Business;

import Notificar.notificarStrategy;

import java.util.List;

public class Persona {
    long id;
    String nombre;
    String apellido;
    String telefono;
    String fechaNacimiento;
    String tipoDocumento;
    int numeroDocumento;
    List<notificarStrategy> formaNotificacion;
    List<Contacto> contactos;
    Usuario usuario;

    public Persona(Long id, String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDocumento, int numeroDocumento, List<notificarStrategy> formaNotificacion,List<Contacto> contactos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.formaNotificacion = formaNotificacion;
        this.contactos = contactos;
    }
    public void agregarContacto(Contacto unContacto){
        contactos.add(unContacto);
    }

    //formaNOtificacion: [WHATSAPP, EMAIL, SMS]
   /* public void serNotificado(Mascota masco){

        for(int i = 0 ; i < formaNotificacion.size() ; i++) {
            formaNotificacion.get(i).notificarMascotaEncontrada(usuario.email, telefono);
        }

        for (Contacto c : contactos ) {
            c.serNotificado();
        }
    }*/


    public String getTelefono() {
        return telefono;
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
