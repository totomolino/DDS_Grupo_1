package Business.services;

import Business.Publicacion;
import Business.Rescate;
import Business.Rescatista;

public class PublicacionPerdida extends Publicacion {
    Rescate rescate;
    Rescatista rescatista;


    public PublicacionPerdida(Rescate rescate, Rescatista rescatista){
        this.rescate = rescate;
        this.rescatista = rescatista;
    }





}


