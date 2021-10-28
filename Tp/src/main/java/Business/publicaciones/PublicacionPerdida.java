package Business.publicaciones;

import Business.Rescate;
import Business.Rescatista;

public class PublicacionPerdida extends Publicacion {
    Rescate rescate;
    Rescatista rescatista;


    public PublicacionPerdida(Long id ,Rescate rescate, Rescatista rescatista){
        super(id);
        this.rescate = rescate;
        this.rescatista = rescatista;
    }


    @Override
    public void mostrar() {
        System.out.println("Perdida -> Se encontro una mascota en X: " + rescate.getLugarEncuentroX() + " Y: " + rescate.getLugarEncuentroY() );
    }

    @Override
    public boolean esDeAdopcion() {
        return false;
    };
}


