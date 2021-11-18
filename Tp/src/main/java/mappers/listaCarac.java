package mappers;

import dominioBD.CaracteristicaOrg;

import java.util.List;
import java.util.stream.Collectors;

public class listaCarac {

    List<String> caracteristicas;

    public listaCarac(List<CaracteristicaOrg> caracteristicas) {
        this.caracteristicas = caracteristicas.stream().map(carac -> carac.getClave()).collect(Collectors.toList());
    }


}
