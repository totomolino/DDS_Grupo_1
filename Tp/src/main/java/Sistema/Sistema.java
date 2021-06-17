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

    public void recibirForms(int idMascota, String nombreResc, String apellidoResc, String telefonoResc, String fechaNac, String tipoDocResc, int numeroDocResc, List<notificarStrategy> formaNotificacion, List<Contacto> contactos, List<Foto> fotos, String descripcionEncuentro, Float posX, Float posY){
        Rescate unRescate = new Rescate(idMascota, fotos, descripcionEncuentro, posX, posY);
        Rescatista unRescatista = new Rescatista(fechaNac, tipoDocResc, numeroDocResc, nombreResc, apellidoResc, telefonoResc, formaNotificacion, contactos);

        if(idMascota != 0) {
            //aca va rescate con chapita id != 0
            Mascota mascota = buscarMascota(idMascota);//Se supone que la encuentra
            mascota.serRescatado();
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
}


