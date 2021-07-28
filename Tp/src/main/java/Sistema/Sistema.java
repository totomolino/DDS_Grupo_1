package Sistema;

import Business.*;
import Business.publicaciones.Publicacion;
import Business.publicaciones.PublicacionDarEnAdopcion;
import Business.publicaciones.PublicacionPerdida;
import Notificar.notificarStrategy;
import seguridad.register;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sistema {

    List<Organizacion> listaDeOrganizaciones = new ArrayList<>();
    private static List<Usuario> listaDeUsuarios = new ArrayList<>();
    List<Voluntario> listaDeVoluntarios = new ArrayList<>();
    List<Publicacion> publicaciones = new ArrayList<>();
    List<Pregunta> preguntasObligatorias = new ArrayList<>();
    private static Sistema instancia = null;

    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        return instancia;
    }


    public static boolean validarContrasenia(String contrasenia, String usuario) throws FileNotFoundException {
        return register.validarContrasenia(contrasenia, usuario);
    }

    public static boolean usuarioNoValido(String usuarioProvisorio) {
        /*if (listaDeUsuarios.stream().anyMatch(usuario -> usuario.getNombre().equals(usuarioProvisorio))){
            return true;}
        else{
            return false;
        }*/
        return listaDeUsuarios.stream().anyMatch(usuario -> usuario.getNombre().equals(usuarioProvisorio));
    }

    public void agregarUsuario(Usuario miUsuario) {
        listaDeUsuarios.add(miUsuario);
    }


    /*   public void crearDuenio() {
           Duenio duenio = new Duenio();
       }*/
    public void crearAdmin() {

    }

    public static void mostrarUsuarios(){
        listaDeUsuarios.forEach(usuario -> usuario.mostrarUsuario());
    }

    public Usuario crearUsuario(String nombre , String contrasenia, TipoDeUsuario tipo, String email){
        Usuario user= new Usuario(tipo,nombre,contrasenia,email);
        this.agregarUsuario(user);
        return user;

    }

    public void agregarVoluntario(Voluntario unVoluntario){
        listaDeVoluntarios.add(unVoluntario);
    }

    public void recibirForms(int idMascota, String nombreResc, String apellidoResc, String telefonoResc, String fechaNac, String tipoDocResc, int numeroDocResc, List<notificarStrategy> formaNotificacion, String email, String contra, String nombreUsuario, List<Contacto> contactos, List<Foto> fotos, String descripcionEncuentro, Float posX, Float posY, boolean seLoQueda, float radioBusqHogarEnM, Tamanio tamanio, Especie especie){
        Rescate unRescate = new Rescate(idMascota, fotos, descripcionEncuentro, posX, posY);
        Usuario miUsuario = new Usuario(TipoDeUsuario.RESCATISTA, nombreUsuario, contra, email);
        Rescatista unRescatista = new Rescatista(nombreResc,apellidoResc,telefonoResc,fechaNac,tipoDocResc,numeroDocResc,formaNotificacion, contactos, miUsuario);
       /* for(Contacto c : contactos) {
            unRescatista.agregarContacto(c);
        }*/


        if(idMascota != 0) {
            //aca va rescate con chapita id != 0
            Mascota mascota = buscarMascota(idMascota);//Se supone que la encuentra
            mascota.serRescatado();
            if(seLoQueda) {

            } else {
                // devolver las opciones y esperar a que elijan una
                // COMO SE HACE PARA ESPERAR ?
                this.hogaresDeTransitoPosibles(posX, posY, radioBusqHogarEnM, tamanio, especie);
                // ESPERA RESPUESTA
                hogarDeTransito respuesta;
                // ACA HAY QUE LLEVAR AL PERRO AL HOGAR, CUANDO LLEGA AL HOGAR, SE "OCUPA EL LUGAR" EN EL HOGAR. SUPONEMOS QUE NO SE "QUEDA RESERVADO" HASTA QUE LLEGUE EL RESCATISTA CON EL PERRO
            }
        }
        else
        {
            //rescate sin chapita id = 0
            this.agregarPublicacionPerdida(unRescatista, unRescate);
        }
    }

    private void agregarPublicacionPerdida(Rescatista unRescatista, Rescate unRescate) {
        PublicacionPerdida unaPublicacion = new PublicacionPerdida(unRescate, unRescatista);
        Organizacion orga = this.encontrarOrganizacionMasCercana(unRescate.lugarEncuentroX,unRescate.lugarEncuentroY);
        orga.agregarPublicacionEnRevision(unaPublicacion);
    }

    private Organizacion encontrarOrganizacionMasCercana(Float lugarEncuentroX, Float lugarEncuentroY) {
        int i=0;
        int posicionElegido=0;
        for (Organizacion organiz : listaDeOrganizaciones){
            if(i==0 ){
                posicionElegido=i;
                i++;
            }
            Organizacion aComparar= listaDeOrganizaciones.get(posicionElegido);
            float distanciaComparar= pasosAdar(aComparar.getX(),aComparar.getY(),lugarEncuentroX,lugarEncuentroY);
            float distCandidato= pasosAdar(organiz.getX(),organiz.getY(),lugarEncuentroX,lugarEncuentroY);
            if(distanciaComparar<distCandidato){
                posicionElegido=i;

            }
            i++;
        }
        Organizacion orgElegidaPorElDestino = listaDeOrganizaciones.get(posicionElegido);
        return orgElegidaPorElDestino;

    }

    private float pasosAdar(float x,float y,float xIr, float yIr){
        float difX,difY,total;
        if (x>xIr){
            difX=x-xIr;
        }else{
            difX=xIr-x;
        }
        if(y>yIr){
            difY=y-yIr;
        }else{
            difY=yIr-y;
        }
        total= difY+difX;
        return total;

    }

    public Mascota buscarMascota(int idMascota) {

        Mascota unaMascota;

        int i = 0;

        while(!listaDeOrganizaciones.get(i).tieneMascota(idMascota)){
            i++;
        }

        unaMascota = listaDeOrganizaciones.get(i).buscarMascota(idMascota);

        return unaMascota;
    }

    public static List<hogarDeTransito> getHogaresDeTransito() {
        List<hogarDeTransito> hogaresDeTransito = new ArrayList<hogarDeTransito>();
        // TODO ACA VA UN METODO QUE AGREGA LOS HOGARES QUE VA LEYENDO DE LA API AL LA LISTA
        return hogaresDeTransito;
    }

    public static List<hogarDeTransito> hogaresDeTransitoPosibles(float posXDelRescate, float posYDelRescate, float radioBusqHogarEnM, Tamanio tamanio, Especie especie) {
        // TODO FILTER DE LA LISTA DE HOGARES DE TRANSITO
        List<hogarDeTransito> hogaresDeTransitoPosibles = new ArrayList<hogarDeTransito>();
        Sistema.getHogaresDeTransito().stream().filter(unHogar -> unHogar.pasaElFiltrado(posXDelRescate, posYDelRescate, radioBusqHogarEnM, tamanio, especie));
        return hogaresDeTransitoPosibles;
    }

    public void mostrarUsuario() {
        Usuario primero = listaDeUsuarios.get(0);
        primero.mostrarUsuario();
    }

    public void agregarDuenio(String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDoc, int numDocumento, List<notificarStrategy> formasDeNotificacion, List<Contacto> contactos, Usuario usuario) {
        Duenio nuevoDuenio = new Duenio(nombre, apellido, telefono, fechaNacimiento, tipoDoc, numDocumento, formasDeNotificacion, contactos, usuario);
        //  TODO A QUE ORGANIZACION PERTENECE EL DUENIO?
    }

    public List<Publicacion> mostrarPublicacionesAprobadas() {
        List<Publicacion> aux = new ArrayList<>();
        for(Organizacion o:listaDeOrganizaciones) {
            aux.addAll(o.publicacionesAprobadas);
        }
        return aux;
    }


    public void darEnAdopcion(String usuarioDuenio, int idMascota) {
        Organizacion orgaDuenio = this.buscarOrgaConUsuario(usuarioDuenio);
        Duenio unDuenio = this.buscarDuenio(usuarioDuenio, orgaDuenio);
        List<Pregunta> preguntasYrespuestasTotales = new ArrayList<>(preguntasObligatorias);
        List<Pregunta> preguntasYrespuestasOrganizacion = new ArrayList<>(orgaDuenio.preguntasOrganizacion);
        preguntasYrespuestasTotales.addAll(preguntasYrespuestasOrganizacion);
        //TODO DEBERIAMOS RECIBIR LAS RESPUESTAS Y PONERLAS CADA UNA EN SU PREGUNTA, LLAMANDO A OTRO METODOS. TAREA PARA OTRO DIA
        Scanner sn = new Scanner(System.in);
        // TODO ACA ESTA PARA AGREGAR LA RTA A LA PREGUNTA, POR SI LO TENEMOS QUE TENER
        for (Pregunta p : preguntasYrespuestasTotales){
            p.mostrar();
            String rta = sn.nextLine();
            p.agregarRta(rta);
        }
        //
        PublicacionDarEnAdopcion unaPublicacion = new PublicacionDarEnAdopcion(this.buscarMascota(idMascota), unDuenio, preguntasYrespuestasTotales);
        //TODO VER SI HAY QUE APROBARLA
    }

    public Duenio buscarDuenio(String unUsuario, Organizacion org) {
        Duenio duenio = org.buscarDuenio(unUsuario);
        return duenio;
    }
    public Organizacion buscarOrgaConUsuario(String unUsuario) {
        Organizacion org = listaDeOrganizaciones.stream().filter(organizacion -> organizacion.tieneDuenio(unUsuario)).collect(Collectors.toList()).get(0);
        return org;
    }



}


