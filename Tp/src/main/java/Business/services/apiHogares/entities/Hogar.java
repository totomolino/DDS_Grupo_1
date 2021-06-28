package Business.services.apiHogares.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Hogar {
    public String id;
    public Ubicacion ubicacion;
    public String telefono;
    public List<Admision> admisiones;
    public int capacidad;
    public int lugaresDisponibles;
    public boolean patio;
    public List<Caracteristica> caracteristicas;


    private class Ubicacion {

        String direccion;
        float lat;
        float longitud;
    }

    private class Admision {

        boolean gato;
        boolean perro;
    }

    private class Caracteristica {

        List <String> caracteristicas;
    }





}
