package Sistema;

import Business.*;
import Business.publicaciones.Publicacion;
import Business.publicaciones.PublicacionAdoptar;
import Business.publicaciones.PublicacionDarEnAdopcion;
import Business.publicaciones.PublicacionPerdida;
import Notificar.notificarStrategy;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dominioBD.*;


import mappers.usuarioIniciarSesion;
import respuestas.*;
import seguridad.register;
import spark.Request;
import spark.Response;
import spark.Spark;
import utils.BDUtils;

import javax.persistence.EntityManager;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Sistema {

    List<Organizacion> listaDeOrganizaciones = new ArrayList<>();
    private static List<Usuario> listaDeUsuarios = new ArrayList<>();
    List<Voluntario> listaDeVoluntarios = new ArrayList<>();
    List<Publicacion> publicaciones = new ArrayList<>();
    List<Adoptante> adoptantes = new ArrayList<>();
    List<Rescatista> rescatistas = new ArrayList<>();
    HashMap<String,String> preguntasObligatorias;
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
        return !BDUtils.puedoEsteNombre(usuarioProvisorio);
        //return listaDeUsuarios.stream().anyMatch(usuario -> usuario.getNombre().equals(usuarioProvisorio));
    }



    /*   public void crearDuenio() {
           Duenio duenio = new Duenio();
       }*/
    public void crearAdmin() {

    }

    public List<PublicacionDarEnAdopcion> publicacionesAptasParaAdoptar(Adoptante unAdoptante) {
        List<PublicacionDarEnAdopcion> publicacionesDarAdopcion = publicaciones.stream().filter(unaPu -> unaPu.esDeAdopcion()).map(publicacion -> (PublicacionDarEnAdopcion) publicacion).collect(Collectors.toList());
        List<PublicacionDarEnAdopcion> publicacionesAptas = unAdoptante.meSirvenLasPublicaciones(publicacionesDarAdopcion);
        return publicacionesAptas;
    }

    public static void mostrarUsuarios(){
        listaDeUsuarios.forEach(usuario -> usuario.mostrarUsuario());
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

    private float pasosAdar(float x,float y,float xIr, float yIr){ //TODO buscar como calcular con lat y long
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
    public void agregarRescatista(String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDoc, int numDocumento, List<notificarStrategy> formasDeNotificacion, List<Contacto> contactos, Usuario usuario) {
        Rescatista nuevoRescatista = new Rescatista(nombre, apellido, telefono, fechaNacimiento, tipoDoc, numDocumento, formasDeNotificacion, contactos, usuario);
        //  TODO A QUE ORGANIZACION PERTENECE EL RESCATISTA?
        rescatistas.add(nuevoRescatista);
    }
    public void agregarAdoptante(String nombre, String apellido, String telefono, String fechaNacimiento, String tipoDoc, int numDocumento, List<notificarStrategy> formasDeNotificacion, List<Contacto> contactos, Usuario usuario) {
        Adoptante nuevoAdoptante = new Adoptante(nombre, apellido, telefono, fechaNacimiento, tipoDoc, numDocumento, formasDeNotificacion, contactos, usuario);
        adoptantes.add(nuevoAdoptante);
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
        HashMap<String,String> preguntasYrespuestasTotales = this.copy(preguntasObligatorias);
        HashMap<String,String> preguntasYrespuestasOrganizacion = this.copy(orgaDuenio.preguntasOrganizacion);

        preguntasYrespuestasTotales.putAll(preguntasYrespuestasOrganizacion);
        //TODO DEBERIAMOS RECIBIR LAS RESPUESTAS Y PONERLAS CADA UNA EN SU PREGUNTA, LLAMANDO A OTRO METODOS. TAREA PARA OTRO DIA
        Scanner sn = new Scanner(System.in);
        // TODO ACA ESTA PARA AGREGAR LA RTA A LA PREGUNTA, POR SI LO TENEMOS QUE TENER
        preguntasYrespuestasTotales.forEach ((k, v) -> {
            System.out.println(k);
            String rta = sn.nextLine();
            preguntasYrespuestasTotales.put(k,rta);
        });
        //
        PublicacionDarEnAdopcion unaPublicacion = new PublicacionDarEnAdopcion(this.buscarMascota(idMascota), unDuenio, preguntasYrespuestasTotales);
        publicaciones.add(unaPublicacion);
        //TODO VER SI HAY QUE AGREGARLA A UNA LISTA DE PUB A APROBAR O QUE ONDA
        //TODO VER SI HAY QUE APROBARLA
    }

    public static HashMap<String, String> copy(HashMap<String, String> original)
    {
        HashMap<String, String> copy = new HashMap<String, String>();
        for (Map.Entry<String, String> entry : original.entrySet())
        {
            copy.put(entry.getKey(), entry.getValue());
        }
        return copy;
    }

    public Duenio buscarDuenio(String unUsuario, Organizacion org) {
        Duenio duenio = org.buscarDuenio(unUsuario);
        return duenio;
    }
    public Organizacion buscarOrgaConUsuario(String unUsuario) {
        Organizacion org = listaDeOrganizaciones.stream().filter(organizacion -> organizacion.tieneDuenio(unUsuario)).collect(Collectors.toList()).get(0);
        return org;
    }

    public void generarPublicacionParaAdoptar(HashMap<String, String> preferenciasYComodidades) {
        Publicacion miPub = new PublicacionAdoptar(preferenciasYComodidades);
        // TODO VER DONDE SE GUARDA ESTA PUBLICACION. EN UNA ORGANIZACION? O ACA? O EN UNA ORG AL AZAR Y DESPUES CUANDO QUEREMOS MOSTRARLO, RECORREMOS TODAS LAS ORGS
    }


    public void recomendarAdoptar(){
        adoptantes.forEach(adoptante -> this.recomendarAdoptante(adoptante));
    }

    private void recomendarAdoptante(Adoptante adoptante) {
        List<PublicacionDarEnAdopcion> publicaciones = this.publicacionesAptasParaAdoptar(adoptante);
        adoptante.recomendarAdopcion(publicaciones);
    }


    //FUNCIONES PRINCIPALES
    // TODO ACA ESTAN LOS SPARKS!!! :) <3 (LOS IRON MANS)
    public static void definePaths(){
        Spark.post("/user", Sistema::crearUsuario);
        Spark.post("/duenio", Sistema::crearDuenio);
        Spark.post("/voluntario", Sistema::crearVoluntario);
        Spark.get("/user", Sistema::iniciarSesion);
        Spark.post("/contacto", Sistema::agregarContacto);
        Spark.post("/notifCont", Sistema::agregarNotificacionCont);
        Spark.post("/notifPers", Sistema::agregarNotificacionPers);
        Spark.post("/mascotas", Sistema::crearMascota);
        Spark.get("/mascotas", Sistema::devolverMascota);
        Spark.post("/mascotaCarac", Sistema::agregarCaracteristicaMascota);
        Spark.post("/rescate", Sistema::encontrarMascota);
        Spark.post("/rescatista", Sistema::crearRescatista);
        Spark.post("/caracAdmin", Sistema::agregarCaracteristicaAdmin);
        //Spark.post("/publicacionPerdida", Sistema::crearPubPerdida);
    }

    public static String crearUsuario(Request req, Response res) throws FileNotFoundException {

        UsuarioBD usuario = new Gson().fromJson(req.body(), UsuarioBD.class);

        res.type("application/json");

        if(!BDUtils.puedoEsteNombre(usuario.getUsu_nombre())) {
            res.status(404);
            return (new mensaje("El nombre de usuario no esta disponible")).transformar();
        }
        if(!(Sistema.validarContrasenia(usuario.getUsu_contrasena(), usuario.getUsu_nombre()))) {
            res.status(404);
            return (new mensaje("La contrasenia ingresada no es valida")).transformar();
        }

        BDUtils.agregarObjeto(usuario);

        res.status(200);


       return (new usuarioCreado(usuario)).transformar();

    }

    public static String iniciarSesion(Request req, Response res){

        usuarioIniciarSesion usuario =  new Gson().fromJson(req.body(), usuarioIniciarSesion.class);

        if(!BDUtils.verificarContrasenia(usuario.getUsuario_Email(),usuario.getContrasenia())){
            res.status(404);
            return (new mensaje("Contrasenia o usuario incorrecto!").transformar());
        }

        res.status(200);
        return (new mensaje("Validado Correctamente!").transformar());

    }

    public static String crearDuenio(Request req, Response res){

        DuenioBD duenio = new Gson().fromJson(req.body(), DuenioBD.class);

        BDUtils.agregarObjeto(duenio);

        res.status(200);

        return (new mensaje("Duenio creado").transformar());
    }

    public static String agregarNotificacionPers(Request req, Response res){
        FormaNotifPers formaNotif =  new Gson().fromJson(req.body(), FormaNotifPers.class);

        BDUtils.agregarObjeto(formaNotif);

        res.status(200);
        return (new mensaje("Notificacion agregada")).transformar();
    }


    public static String agregarContacto(Request req, Response res){
        ContactoBD contacto = new Gson().fromJson(req.body(), ContactoBD.class);

        BDUtils.agregarObjeto(contacto);

        return (new mensaje("Contacto agregado")).transformar();
    }

    public static String agregarNotificacionCont(Request req, Response res){
        FormaNotifCont formaNotif =  new Gson().fromJson(req.body(), FormaNotifCont.class);

        BDUtils.agregarObjeto(formaNotif);

        res.status(200);
        return (new mensaje("Notificacion agregada")).transformar();
    }


    public static String crearMascota(Request req, Response res){
        MascotaBD mascotaBD =  new Gson().fromJson(req.body(), MascotaBD.class);

        BDUtils.agregarObjeto(mascotaBD);

        res.status(200);
        return (new mensaje("Notificacion agregada")).transformar();
    }

    public static String devolverMascota(Request req, Response res){
        id mascotaID =  new Gson().fromJson(req.body(), id.class);

        MascotaBD mascota = BDUtils.buscarMascota(mascotaID.getId());

        res.status(200);
        return (new devolverObjeto(mascota,"Toma la mascota gato")).transformar();
    }

    public static String agregarCaracteristicaMascota(Request req, Response res){

        CarMasXMas caracteristicas = new Gson().fromJson(req.body(), CarMasXMas.class);

        BDUtils.agregarObjeto(caracteristicas);

        res.status(200);
        return (new mensaje("Se agrego las caracteristicas a la mascota")).transformar();
    }

    public static String encontrarMascota(Request req, Response res){
        RescateBD rescateBD = new Gson().fromJson(req.body(), RescateBD.class);

        BDUtils.agregarObjeto(rescateBD);

        res.status(200);
        return (new mensaje("Se creo el rescate")).transformar();
    }

    public static String crearRescatista(Request req, Response res){
        RescatistaBD rescatistaBD = new Gson().fromJson(req.body(), RescatistaBD.class);

        BDUtils.agregarObjeto(rescatistaBD);

        res.status(200);
        return (new devolverObjeto(rescatistaBD, "Se creo un rescatista")).transformar();
    }


    public static String crearVoluntario(Request req, Response res){
        VoluntarioBD voluntarioBD = new Gson().fromJson(req.body(), VoluntarioBD.class);

        BDUtils.agregarObjeto(voluntarioBD);

        res.status(200);
        return (new devolverObjeto(voluntarioBD, "Se creo un voluntario")).transformar();
    }

    //DAR EN ADOPCION


    //ADOPTAR


    //ADMIN AGREGAR CARACTERISTICA

    public static String agregarCaracteristicaAdmin(Request req, Response res){
        CaracteristicaMascota caracteristicas = new Gson().fromJson(req.body(), CaracteristicaMascota.class);

        BDUtils.agregarObjeto(caracteristicas);

        res.status(200);
        return (new mensaje("Se agrego la caracteristica correctamente").transformar());
    }


    //

   /* crearVoluntario public static String crearPubPerdida(Request req, Response res){
        PublicacionPerdida rescateBD = new Gson().fromJson(req.body(), RescateBD.class);

        BDUtils.agregarObjeto(rescateBD);

        res.status(200);
        return (new mensaje("Se creo el rescate")).transformar();
    }*/


























}


