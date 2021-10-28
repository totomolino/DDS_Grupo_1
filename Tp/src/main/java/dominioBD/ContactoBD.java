package dominioBD;

import Business.Contacto;
import Notificar.notificarStrategy;
import utils.BDUtils;

import javax.persistence.*;
import java.util.List;

@Table(name = "contacto_bd")
@Entity
public class ContactoBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cont_id;

    private String cont_nombre;
    private String cont_apellido;
    private String cont_telefono;
    private String cont_email;

    @ManyToOne
    @JoinColumn (name = "pers_id")
    private PersonaBD cont_persona;

    @OneToMany(mappedBy = "fonoc_contacto")
    private List<FormaNotifCont>formaNotifConts;

    public Long getCont_id() {
        return cont_id;
    }

    public void setCont_id(Long cont_id) {
        this.cont_id = cont_id;
    }

    public String getCont_nombre() {
        return cont_nombre;
    }

    public void setCont_nombre(String cont_nombre) {
        this.cont_nombre = cont_nombre;
    }

    public String getCont_apellido() {
        return cont_apellido;
    }

    public void setCont_apellido(String cont_apellido) {
        this.cont_apellido = cont_apellido;
    }

    public String getCont_telefono() {
        return cont_telefono;
    }

    public void setCont_telefono(String cont_telefono) {
        this.cont_telefono = cont_telefono;
    }

    public String getCont_email() {
        return cont_email;
    }

    public void setCont_email(String cont_email) {
        this.cont_email = cont_email;
    }

    public PersonaBD getCont_persona() {
        return cont_persona;
    }

    public void setCont_persona(PersonaBD cont_persona) {
        this.cont_persona = cont_persona;
    }

    public List<FormaNotifCont> getFormaNotifConts() {
        return formaNotifConts;
    }

    public void setFormaNotifConts(List<FormaNotifCont> formaNotifConts) {
        this.formaNotifConts = formaNotifConts;
    }

    public Contacto transformar() {
        List<notificarStrategy> listaNotif = BDUtils.dameListaNotifCont(cont_id);
        Contacto contacto = new Contacto(cont_id, cont_nombre,cont_apellido,cont_telefono,listaNotif,cont_email);
        return contacto;
    }
}