package Notificar;

import Business.Adoptante;
import Business.Mascota;
import Business.Persona;

public class EMAIL extends notificarStrategy{

    @Override
    public void notificarMascotaEncontrada(String email, String telefono, Mascota mascota) {
        twilio.mandarEmail(email, "Encontramos a tu mascota "+ mascota.getApodo());
    }

    @Override
    public void notificarAdopcion(String email, String telefono, Adoptante adoptante) {
        twilio.mandarEmail(email, "Encontramos un interesado llamado "+ adoptante.getNombre());
    }


}
