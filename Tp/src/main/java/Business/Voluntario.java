package Business;

import Business.publicaciones.Publicacion;

public class Voluntario {

    public int tamanioFotos;
    Usuario usuario;
    Organizacion organizacion;

    public Voluntario(String nombre, String contrasenia, String email, int tamanioFotos, Organizacion organizacion) {
        //this.usuario = new Usuario(TipoDeUsuario.VOLUNTARIO, nombre, contrasenia, email);
        this.tamanioFotos = tamanioFotos;
        this.organizacion = organizacion;
    }

    public void normalizarFoto(){}

    public void ajustarCalidad(){}

    public void aprobarPublicacion(){
        Publicacion miPublicacion = organizacion.obtenerUnaPublicacionEnRevision();
        if(this.validarPublicacion(miPublicacion)){
            organizacion.agregarPublicacionAprobada(miPublicacion);
        }
    }

    // VER COMO VALIDAR
    public boolean validarPublicacion(Publicacion miPublicacion){
        return true;
    }

    public void borrarPublicacion(Publicacion unaPublicacion) {
        organizacion.borrarPublicacionAprobada(unaPublicacion);
    }
}
