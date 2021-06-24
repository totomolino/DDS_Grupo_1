package Notificar;

import Business.Persona;

public class WHATSAPP extends notificarStrategy{

    @Override
    public void notificarA(String email, String telefono) {

        twilio.mandarWhatsapp(telefono, "Encontre a tu perro");


    }
}


