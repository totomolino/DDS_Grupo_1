package Notificar;

import Business.Persona;

public class WHATSAPP extends notificarStrategy{

    @Override
    public void serNotificado(Persona persona) {

        twilio.mandarWhatsapp(persona.getTelefono(), "Encontre a tu perro");


    }
}


