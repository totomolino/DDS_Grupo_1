package Business;

import Business.publicaciones.Publicacion;
import Business.publicaciones.PublicacionDarEnAdopcion;
import Notificar.notificarStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Adoptante extends Persona{
    HashMap<String, String> comodidades;
    HashMap<String, String> preferencias;
    boolean cumple = true;
    boolean cumpleC = true;

    public Adoptante(long id, String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDocumento, int numeroDocumento, List<notificarStrategy> formaNotificacion, List<Contacto> contactos, Usuario usuario, HashMap<String, String> comodidades, HashMap<String, String> preferencias) {
        super(id, nombre, apellido, telefono, fechaNacimiento, tipoDocumento, numeroDocumento, formaNotificacion, contactos);
        this.usuario = usuario;
        this.comodidades = comodidades;
        this.preferencias = preferencias;
    }

    public void quieroAdoptar(PublicacionDarEnAdopcion unaPubl) {
        (unaPubl.duenio).serNotificadoAdopcion(this);
    }

    public List<PublicacionDarEnAdopcion> meSirvenLasPublicaciones(List<PublicacionDarEnAdopcion> publicacionesDarAdopcion) {
        List<PublicacionDarEnAdopcion> publicacionesQueMeSirven = publicacionesDarAdopcion.stream().filter(publicacion -> this.meSSirve(publicacion)).collect(Collectors.toList());
        return publicacionesQueMeSirven;
    }

    private boolean meSSirve(PublicacionDarEnAdopcion publicacion) {
       return this.MascotaCompatibleBelleza(publicacion.mascota.caracteristicas) && this.mascotaCompatibleComodidad(publicacion.preguntas);
    }

    private boolean MascotaCompatibleBelleza(HashMap<String,String> caracteristicas){
        cumple = true;
        preferencias.forEach((k,v) -> this.contieneKeyBelleza(k, v, caracteristicas));
        return cumple;
    }

    private void contieneKeyBelleza(String k, String v, HashMap<String,String> caracteristicas){
        if(caracteristicas.containsKey(k)) {
            cumple = (caracteristicas.get(k) == v && cumple);
        }
    }


    private boolean mascotaCompatibleComodidad(HashMap<String,String> preguntas){
        cumpleC = true;
        preguntas.forEach((k,v) -> this.contieneKeyComodidad(k, v));
        return cumpleC;
    }

    private void contieneKeyComodidad(String k, String v){
        if(comodidades.containsKey(k)) {
            cumpleC = (comodidades.get(k) == v && cumpleC);
        }
    }

    public void recomendarAdopcion(List<PublicacionDarEnAdopcion> publicaciones) {
        //TODO MANDAR MAIL O MOSTRAR EN LA PAGINA??
    }
}

