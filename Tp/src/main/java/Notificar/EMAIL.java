package Notificar;

import Business.Persona;

public class EMAIL extends notificarStrategy{

    @Override
    public void serNotificado(Persona persona) {
        twilio.mandarEmail(persona.getEmail(), "Encontre a tu perro");
    }


}
