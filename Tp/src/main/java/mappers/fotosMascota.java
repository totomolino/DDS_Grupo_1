package mappers;

import dominioBD.FotoAnimales;

import java.util.ArrayList;
import java.util.List;

public class fotosMascota {


    List<FotoAnimales> fotos ;

    public fotosMascota(List<FotoAnimales> fotos) {
        this.fotos = fotos;
    }

    public List<FotoAnimales> getFotos() {
        return fotos;
    }

    public void setFotos(List<FotoAnimales> fotos) {
        this.fotos = fotos;
    }
}
