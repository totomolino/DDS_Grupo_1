package Business.publicaciones;

import Business.*;

import java.util.List;

public class PublicacionDarEnAdopcion extends Publicacion {
    public Mascota mascota;
    public Duenio duenio;
    List<Pregunta> preguntas;

    public PublicacionDarEnAdopcion(Mascota unaMascota, Duenio duenio, List<Pregunta> preguntas){
        this.mascota = unaMascota;
        this.duenio = duenio;
        this.preguntas = preguntas;
    }


    @Override
    public void mostrar() {
        System.out.println("Mascota en adopcion -> Doy en adopcion a mi mascota " + mascota.getApodo());
    }
}


