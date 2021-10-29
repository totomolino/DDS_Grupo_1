package dominioBD;

import Business.Adoptante;
import Business.Contacto;
import Business.Duenio;
import Business.Usuario;
import Notificar.notificarStrategy;
import utils.BDUtils;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

//@Table(name = "adoptante_bd")
@Entity
public class AdoptanteBD extends PersonaBD{


    @OneToMany (mappedBy = "comoXad_adoptante")
    private List<ComodidadesXadoptante> comodidades;

    @OneToMany (mappedBy = "prefXado_adoptante")
    private List<PreferenciaXAdoptante> preferencias;


    public List<ComodidadesXadoptante> getComodidades() {
        return comodidades;
    }

    public void setComodidades(List<ComodidadesXadoptante> comodidades) {
        this.comodidades = comodidades;
    }

    public List<PreferenciaXAdoptante> getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(List<PreferenciaXAdoptante> preferencias) {
        this.preferencias = preferencias;
    }

    public Adoptante transformar() {
        Long id = this.getPers_id();
        String nombre = this.getPers_nombre();
        String apellido = this.getPers_apellido();
        String telefono = this.getPers_telefono();
        String fechaNacimiento = this.getPers_fechaNacimiento();
        String tipoDocumento = this.getPers_tipoDocumento();
        int numeroDoc = this.getPers_documento();
        List<notificarStrategy> listaNotif = BDUtils.dameListaNotif(id);
        List<Contacto> listaContactos = BDUtils.dameContactos(id);
        Usuario usuario = this.getPers_usuario().transformar();
        HashMap<String, String> comodidades = BDUtils.dameComodidadesAdoptante(id);
        HashMap<String, String> preferencias = BDUtils.damePreferenciasAdoptante(id);

        Adoptante adoptante = new Adoptante(id,nombre,apellido,telefono,fechaNacimiento,tipoDocumento,numeroDoc,listaNotif,listaContactos,usuario, comodidades, preferencias);

        return adoptante;
    }
}