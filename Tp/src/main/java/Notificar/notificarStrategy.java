package Notificar;

import Business.Adoptante;
import Business.Mascota;
import Business.Persona;

public abstract class notificarStrategy {

    public abstract void notificarMascotaEncontrada(String email, String telefono, Mascota mascota);

    public abstract void notificarAdopcion(String email, String telefono, Adoptante adoptante);

}
