package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "persona")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PersonaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pers_id;

    private String pers_nombre;
    private String pers_apellido;
    private String pers_fechaNacimiento;
    private int pers_documento;
    private String pers_tipoDocumento;
    private String pers_telefono;


    @OneToOne
    private UsuarioBD pers_usuario;


    @OneToMany(mappedBy = "cont_persona")
    private List<ContactoBD>contactoBDS;

    @OneToMany(mappedBy = "fonop_persona")
    private List<FormaNotifPers>formaNotifPers;

    public Long getPers_id() {
        return pers_id;
    }

    public void setPers_id(Long pers_id) {
        this.pers_id = pers_id;
    }

    public String getPers_nombre() {
        return pers_nombre;
    }

    public void setPers_nombre(String pers_nombre) {
        this.pers_nombre = pers_nombre;
    }

    public String getPers_apellido() {
        return pers_apellido;
    }

    public void setPers_apellido(String pers_apellido) {
        this.pers_apellido = pers_apellido;
    }

    public String getPers_fechaNacimiento() {
        return pers_fechaNacimiento;
    }

    public void setPers_fechaNacimiento(String pers_fechaNacimiento) {
        this.pers_fechaNacimiento = pers_fechaNacimiento;
    }

    public int getPers_documento() {
        return pers_documento;
    }

    public void setPers_documento(int pers_documento) {
        this.pers_documento = pers_documento;
    }

    public String getPers_tipoDocumento() {
        return pers_tipoDocumento;
    }

    public void setPers_tipoDocumento(String pers_tipoDocumento) {
        this.pers_tipoDocumento = pers_tipoDocumento;
    }

    public String getPers_telefono() {
        return pers_telefono;
    }

    public void setPers_telefono(String pers_telefono) {
        this.pers_telefono = pers_telefono;
    }

    public UsuarioBD getPers_usuario() {
        return pers_usuario;
    }

    public void setPers_usuario(UsuarioBD pers_usuario) {
        this.pers_usuario = pers_usuario;
    }

    public List<ContactoBD> getContactoBDS() {
        return contactoBDS;
    }

    public void setContactoBDS(List<ContactoBD> contactoBDS) {
        this.contactoBDS = contactoBDS;
    }

    public List<FormaNotifPers> getFormaNotifPers() {
        return formaNotifPers;
    }

    public void setFormaNotifPers(List<FormaNotifPers> formaNotifPers) {
        this.formaNotifPers = formaNotifPers;
    }
}
