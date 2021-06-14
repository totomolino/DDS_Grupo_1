package Notificar;

import Business.Persona;

public class SMS extends notificarStrategy{


    @Override
    public void serNotificado(Persona persona) {
        twilio.mandarSMS(persona.getTelefono(), "Encontre a tu perro");
    }

}
