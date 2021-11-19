package mappers;

import dominioBD.CarMasXMas;

import java.util.List;

public class caracMascota {

    List<CarMasXMas> caracteristicas;

    public caracMascota(List<CarMasXMas> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public List<CarMasXMas> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<CarMasXMas> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
