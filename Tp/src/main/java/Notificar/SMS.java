package Notificar;

import Business.Adoptante;
import Business.Mascota;
import Business.Persona;

public class SMS extends notificarStrategy{


    @Override
    public void notificarMascotaEncontrada(String email, String telefono, Mascota mascota) {
        twilio.mandarSMS(telefono, "Encontramos a tu mascota "+ mascota.getApodo());
    }

    @Override
    public void notificarAdopcion(String email, String telefono, Adoptante adoptante) {
        twilio.mandarSMS(telefono, "Encontramos un interesado llamado "+ adoptante.getNombre());
    }

}
