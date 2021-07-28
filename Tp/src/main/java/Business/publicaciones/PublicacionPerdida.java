package Business.publicaciones;

import Business.Rescate;
import Business.Rescatista;

public class PublicacionPerdida extends Publicacion {
    Rescate rescate;
    Rescatista rescatista;


    public PublicacionPerdida(Rescate rescate, Rescatista rescatista){
        this.rescate = rescate;
        this.rescatista = rescatista;
    }


    @Override
    public void mostrar() {
        System.out.println("Perdida -> Se encontro una mascota en X: " + rescate.getLugarEncuentroX() + " Y: " + rescate.getLugarEncuentroY() );
    }
}


