package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Organizacion {

    List<Mascota> listaMascotas = new ArrayList<>();
    List<Duenio> listaDuenios = new ArrayList<>();
    List<String> caracteristicas = new ArrayList<>();
    Administrador miAdmin;


    public void agregarMascota(int id, Especie especie, String nombre, String apodo, int edad, String sexo, String descripcion, List<Foto> fotos, Duenio duenio, HashMap<String, String> caracteristicas) {
        Mascota unaMascota = new Mascota(id , fotos, especie, nombre, apodo, edad, sexo, descripcion, true, caracteristicas);
        listaMascotas.add(unaMascota);
        duenio.agregarMascota(unaMascota);
    }

    public void agregarCaracteristica(String unaCarateristica) {
        caracteristicas.add(unaCarateristica);
    }













































}
