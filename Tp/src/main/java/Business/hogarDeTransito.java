package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hogarDeTransito {

    List<Especie> aceptaEspecies = new ArrayList<>();
    boolean poseePatio;
    int capacidad;
    int lugaresOcupados;
    float posX;
    float posY;
    HashMap<String, String> caracPuntuales;

    public boolean puedeAlojar(Especie tipoEspecie, Tamanio tamanioMascota){
        return this.puedeAlojarEspecie(tipoEspecie) && this.puedeAlojarSegunTamanio(tamanioMascota) && this.hayLugar();
    }

    public boolean hayLugar(){
        boolean hayLugar = capacidad > lugaresOcupados;
        return hayLugar;
    }

    public boolean puedeAlojarEspecie( Especie tipo){
        return aceptaEspecies.contains(tipo);
    }

    public boolean puedeAlojarSegunTamanio(Tamanio tamanio){
        if(poseePatio) {
            return true;
        }
        else {
            return tamanio == Tamanio.CHICA;
        }
    }

    public boolean pasaElFiltrado(float posXDelRescate, float posYDelRescate, float radioBusqHogarEnM, Tamanio tamanio, Especie especie) {
        return this.cumpleFiltradoDistacia(posXDelRescate, posYDelRescate, radioBusqHogarEnM) && puedeAlojar(especie, tamanio);
    }

    public boolean cumpleFiltradoDistacia(float posXDelRescate, float posYDelRescate, float radioBusqHogarEnM) {
        float distanciaX = posXDelRescate - posX;
        float distanciaY = posYDelRescate - posY;
        return (radioBusqHogarEnM * radioBusqHogarEnM) <= ((distanciaX * distanciaX) + (distanciaY * distanciaY));
    }
}