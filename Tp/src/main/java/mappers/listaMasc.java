package mappers;

import Business.Mascota;
import respuestas.mascotaSimple;

import java.util.List;

public class listaMasc {

    List<mascotaSimple> mascotas;

    public listaMasc(List<mascotaSimple> mascotas) {
        this.mascotas = mascotas;
    }

    public List<mascotaSimple> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<mascotaSimple> mascotas) {
        this.mascotas = mascotas;
    }
}
