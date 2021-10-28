package Business.publicaciones;

import java.util.HashMap;

public class PublicacionAdoptar extends Publicacion {
    HashMap<String,String> preferenciasYComodidades;



    public PublicacionAdoptar(Long id, HashMap<String, String> preferencias) {
        super(id);
        this.preferenciasYComodidades = preferencias;
    }

    @Override
    public void mostrar() {
        System.out.println("Adoptar -> Se desea adoptar una mascota: " + preferenciasYComodidades.get(1));
    }

    @Override
    public boolean esDeAdopcion() {
        return false;
    };


}


