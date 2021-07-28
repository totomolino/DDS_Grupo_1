package Business.publicaciones;

import Business.Rescate;
import Business.Rescatista;

import java.util.HashMap;

public class PublicacionAdoptar extends Publicacion {
    HashMap<String,String> preferencias;

    @Override
    public void mostrar() {
        System.out.println("Adoptar -> Se desea adoptar una mascota: " + preferencias.get(1));
    }


}


