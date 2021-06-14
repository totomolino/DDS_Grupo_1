package Business;

import Notificar.notificarStrategy;

import java.util.List;

public class Voluntario extends Usuario{

    public int tamanioFotos;

    public Voluntario(TipoDeUsuario tipoDeUsuario, String nombre, String contrasenia, String email, int tamanioFotos) {
        super(tipoDeUsuario, nombre, contrasenia, email);
        this.tamanioFotos = tamanioFotos;
    }

    public void normalizarFoto(){}

    public void ajustarCalidad(){}

    public void aprobarPublicacion(){

    }



}
