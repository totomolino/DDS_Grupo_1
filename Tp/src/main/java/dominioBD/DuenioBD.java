package dominioBD;

import Business.Contacto;
import Business.Duenio;
import Business.Usuario;
import Notificar.notificarStrategy;
import utils.BDUtils;

import javax.persistence.*;
import java.util.List;

@Entity
public class DuenioBD extends PersonaBD {

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long due_id;*/

    @ManyToOne
    @JoinColumn(name = "orga_id")
    private OrganizacionBD due_organizacion;

    @OneToMany(mappedBy = "masc_duenio")
    private List<MascotaBD> mascotas;

    public OrganizacionBD getDue_organizacion() {
        return due_organizacion;
    }

    public void setDue_organizacion(OrganizacionBD due_organizacion) {
        this.due_organizacion = due_organizacion;
    }

    public Duenio transformar() {
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
        Duenio duenio = new Duenio(id,nombre,apellido,telefono,fechaNacimiento,tipoDocumento,numeroDoc,listaNotif,listaContactos,usuario);
        return duenio;
    }

    public List<MascotaBD> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaBD> mascotas) {
        this.mascotas = mascotas;
    }
}