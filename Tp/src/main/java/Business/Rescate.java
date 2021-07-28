package Business;

import java.util.ArrayList;
import java.util.List;

public class Rescate {

    public List<Foto> listaDeFotos;
    public String descripcionEstado;
    public Float lugarEncuentroX;
    public Float lugarEncuentroY;
    public int idMascota;

    public Rescate(int idMascota, List<Foto> listaDeFotos, String descripcionEstado, Float lugarEncuentroX, Float lugarEncuentroY) {
        this.idMascota = idMascota;
        this.listaDeFotos = listaDeFotos;
        this.descripcionEstado = descripcionEstado;
        this.lugarEncuentroX = lugarEncuentroX;
        this.lugarEncuentroY = lugarEncuentroY;
    }
    public float getLugarEncuentroX(){
        return lugarEncuentroX;
    }

    public float getLugarEncuentroY(){
        return lugarEncuentroY;
    }

}
