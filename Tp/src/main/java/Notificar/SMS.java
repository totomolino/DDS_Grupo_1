package Notificar;

import Business.Persona;

public class SMS extends notificarStrategy{


    @Override
    public void notificarA(String email, String telefono) {
        twilio.mandarSMS(telefono, "Encontre a tu perro");
    }

}
