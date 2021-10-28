package Business;

import Notificar.notificarStrategy;

import java.util.List;

public class Contacto {
    Long id;
    String nombre;
    String apellido;
    String telefono;
    String email;
    List<notificarStrategy> formaNotificacion;


    public Contacto(Long id,String nombre, String apellido, String telefono, List<notificarStrategy> formaNotificacion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.formaNotificacion = formaNotificacion;
        this.email = email;
    }

    public void notifcarMascotaEncontrada(Mascota mascota){

        for(int i = 0 ; i < formaNotificacion.size() ; i++){

            formaNotificacion.get(i).notificarMascotaEncontrada(email, telefono, mascota);

        }
    }

    public void notificarAdopcion(Adoptante adoptante){

        for(int i = 0 ; i < formaNotificacion.size() ; i++){

            formaNotificacion.get(i).notificarAdopcion(email, telefono, adoptante);

        }
    }


}
