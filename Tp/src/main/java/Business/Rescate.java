package Business;

import java.util.ArrayList;
import java.util.List;

public class Rescate {

    List<Foto> listaDeFotos = new ArrayList<>();
    String descripcionEstado;
    Float lugarEncuentroX;
    Float lugarEncuentroY;
    int idMascota;

    public Rescate(int idMascota, List<Foto> listaDeFotos, String descripcionEstado, Float lugarEncuentroX, Float lugarEncuentroY) {
        this.idMascota = idMascota;
        this.listaDeFotos = listaDeFotos;
        this.descripcionEstado = descripcionEstado;
        this.lugarEncuentroX = lugarEncuentroX;
        this.lugarEncuentroY = lugarEncuentroY;
    }
}
