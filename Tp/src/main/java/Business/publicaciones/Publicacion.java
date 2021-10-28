package Business.publicaciones;

import Business.Foto;

import java.util.ArrayList;
import java.util.List;

public abstract class Publicacion {

    Long id;

    public Publicacion(Long id) {
        this.id = id;
    }

    public void serAprobada(){}

    public abstract void mostrar();

    public abstract boolean esDeAdopcion();
}
