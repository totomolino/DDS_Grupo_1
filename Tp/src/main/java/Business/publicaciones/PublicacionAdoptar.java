package Business.publicaciones;

import java.util.HashMap;

public class PublicacionAdoptar extends Publicacion {
    HashMap<String,String> preferenciasYComodidades;



    public PublicacionAdoptar(HashMap<String, String> preferencias) {
        this.preferenciasYComodidades = preferencias;
    }

    @Override
    public void mostrar() {
        System.out.println("Adoptar -> Se desea adoptar una mascota: " + preferenciasYComodidades.get(1));
    }


}


