package Notificar;

import Business.Persona;

public class EMAIL extends notificarStrategy{

    @Override
    public void notificarA(String email, String telefono) {
        twilio.mandarEmail(email, "Encontre a tu perro");
    }


}
