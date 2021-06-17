package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hogaresDeTransito {

    List<Especie> aceptaEspecies = new ArrayList<>();
    boolean poseePatio;
    int capacidad;
    int lugaresOcupados;
    int radioCercania;
    HashMap<String, String> caracPuntuales;

    public boolean puedeAlojar(Especie tipoEspecie, String tamanioMascota  ){
        return this.puedeAlojarEspecie(tipoEspecie) && this.puedeAlojarSegunTamanio(tamanioMascota);
    }

    public boolean puedeAlojarEspecie( Especie tipo){
        return aceptaEspecies.contains(tipo);
    }

    public boolean (String tamanio){
        return true;
    }




}
