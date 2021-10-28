package Business.publicaciones;

import Business.*;

import java.util.HashMap;
import java.util.List;

public class PublicacionDarEnAdopcion extends Publicacion {
    public Mascota mascota;
    public Duenio duenio;
    public HashMap<String,String> preguntas;

    public PublicacionDarEnAdopcion(Long id, Mascota unaMascota, Duenio duenio, HashMap<String,String> preguntas){
        super(id);
        this.mascota = unaMascota;
        this.duenio = duenio;
        this.preguntas = preguntas;
    }

    public Mascota getMascota() {
        return mascota;
    }

    @Override
    public void mostrar() {
        System.out.println("Mascota en adopcion -> Doy en adopcion a mi mascota " + mascota.getApodo());
    }

    @Override
    public boolean esDeAdopcion() {
        return true;
    };
}


