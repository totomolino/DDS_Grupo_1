package Sistema;

import Business.*;
import Notificar.notificarStrategy;
import org.antlr.misc.IntArrayList;
import seguridad.register;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sistema {

    List<Organizacion> listaDeOrganizaciones = new ArrayList<>();
    List<Usuario> listaDeUsuarios = new ArrayList<>();
    List<Voluntario> listaDeVoluntarios = new ArrayList<>();


    public static void validarContrasenia(String contrasenia, String usuario) throws FileNotFoundException {
        register.validarContrasenia(contrasenia, usuario);
    }



    /*   public void crearDuenio() {
           Duenio duenio = new Duenio();
       }*/
    public void crearAdmin() {

    }

    public void agregarVoluntario(Voluntario unVoluntario){
        listaDeVoluntarios.add(unVoluntario);
    }

    public void recibirForms(int idMascota, String nombreResc, String apellidoResc, String telefonoResc, String fechaNac, String tipoDocResc, int numeroDocResc, List<notificarStrategy> formaNotificacion, String email, String contra, String nombreUsuario, List<Contacto> contactos, List<Foto> fotos, String descripcionEncuentro, Float posX, Float posY, boolean seLoQueda, int radioBusqHogarEnM, Tamanio tamanio, Especie especi){
        Rescate unRescate = new Rescate(idMascota, fotos, descripcionEncuentro, posX, posY);
        Rescatista unRescatista = new Rescatista(nombreResc,apellidoResc,telefonoResc,fechaNac,tipoDocResc,numeroDocResc,formaNotificacion,email,contra,nombreUsuario);
        for(Contacto c : contactos) {
            unRescatista.agregarContacto(c);
        }


        if(idMascota != 0) {
            //aca va rescate con chapita id != 0
            Mascota mascota = buscarMascota(idMascota);//Se supone que la encuentra
            mascota.serRescatado();
            if(seLoQueda) {

            } else {
                // devolver las opciones y esperar a que elijan una
                // COMO SE HACE PARA ESPERAR ?
                this.hogaresDeTransitoPosibles(posX, posY, radioBusqHogarEnM, tamanio,especie);
            }
        }
        else
        {
            //rescate sin chapita id = 0
        }
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
        // ACA VA UN METODO QUE AGREGA LOS HOGARES QUE VA LEYENDO DE LA API AL LA LISTA
        return hogaresDeTransito;
    }

    public static List<hogarDeTransito> hogaresDeTransitoPosibles(float posXDelRescate, float posYDelRescate, int radioBusqHogarEnM, Tamanio tamanio) {
        // FILTER DE LA LISTA DE HOGARES DE TRANSITO
        List<hogarDeTransito> hogaresDeTransitoPosibles = new ArrayList<hogarDeTransito>();
        Sistema.getHogaresDeTransito().stream().filter(unHogar -> unHogar.pasaElFiltrado(posXDelRescate, posYDelRescate, radioBusqHogarEnM, tamanio, ))
        return hogaresDeTransitoPosibles;
    }
}


