package Business;

import Business.publicaciones.Publicacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Organizacion {

    List<Mascota> listaMascotas = new ArrayList<>();
    List<Duenio> listaDuenios = new ArrayList<>();
    List<String> caracteristicas = new ArrayList<>();
    List<Administrador> misAdmins = new ArrayList<>();
    List<Publicacion> publicacionesEnRevision = new ArrayList<>();
    public List<Pregunta> preguntasOrganizacion = new ArrayList<>();
    public List<Publicacion> publicacionesAprobadas = new ArrayList<>();
    float posX;
    float posY;


    public void agregarMascota(int id, Especie especie, String nombre, String apodo, int edad, String sexo, String descripcion, List<Foto> fotos, Duenio duenio, HashMap<String, String> caracteristicas) {
        Mascota unaMascota = new Mascota(id , fotos, especie, nombre, apodo, edad, sexo, descripcion, true, caracteristicas, duenio);
        listaMascotas.add(unaMascota);
        duenio.agregarMascota(unaMascota);
    }

    public void agregarCaracteristica(String unaCarateristica) {
        caracteristicas.add(unaCarateristica);
    }

    public void agregarAdmin(Administrador unAdmin) {
        misAdmins.add(unAdmin);
    }

    public boolean tieneMascota(int idMascota) {

        return listaMascotas.stream().anyMatch(mascota -> mascota.getId() == (idMascota));
    }

    public void cambiarPreguntas(List<Pregunta> preguntasNuevas) {
        preguntasOrganizacion.addAll(preguntasNuevas) ;
    }


    public Mascota buscarMascota(int idMascota) {
        return listaMascotas.stream().filter(mascota -> mascota.getId() == idMascota).findFirst().orElse(null);
    }

    public void agregarPublicacionEnRevision(Publicacion publicacion) {
        publicacionesEnRevision.add(publicacion);
    }

    public void agregarPublicacionAprobada(Publicacion publicacion) {
        publicacionesAprobadas.add(publicacion);
    }

    public Publicacion obtenerUnaPublicacionEnRevision() {//Agarra una publicacion y la saca de la lista
        return publicacionesEnRevision.remove(0);
    }

    public void borrarPublicacionAprobada(Publicacion unaPublicacion){
        publicacionesAprobadas.remove(unaPublicacion);
    }

    public float getX(){return posX;}

    public float getY(){return posY;}


    public boolean tieneDuenio(String unUsuario) {
        return listaDuenios.stream().anyMatch(duenio -> duenio.tieneXUsuario(unUsuario));
    }

    public Duenio buscarDuenio(String unUsuario) {
        Duenio duenio = listaDuenios.stream().filter(due -> due.tieneXUsuario(unUsuario)).collect(Collectors.toList()).get(0);
        return duenio;
    }
}



