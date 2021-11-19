package dominioBD;

import Notificar.EMAIL;
import Notificar.SMS;
import Notificar.WHATSAPP;
import Notificar.notificarStrategy;

import javax.persistence.*;

@Table(name = "forma_notif_cont")
@Entity
public class FormaNotifCont {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fonoc_id;

    @ManyToOne
    @JoinColumn(name = "cont_id")
    private ContactoBD fonoc_contacto;

    private String fonoc_forma;

    public Long getFonoc_id() {
        return fonoc_id;
    }

    public void setFonoc_id(Long fonoc_id) {
        this.fonoc_id = fonoc_id;
    }

    public ContactoBD getFonoc_contacto() {
        return fonoc_contacto;
    }

    public void setFonoc_contacto(ContactoBD fonoc_contacto) {
        this.fonoc_contacto = fonoc_contacto;
    }

    public String getFonoc_forma() {
        return fonoc_forma;
    }

    public void setFonoc_forma(String fonoc_forma) {
        this.fonoc_forma = fonoc_forma;
    }

    public notificarStrategy transformar() {
        if(fonoc_forma.equalsIgnoreCase("SMS"))
            return new SMS();
        else if(fonoc_forma.equalsIgnoreCase("EMAIL"))
            return new EMAIL();
        else
            return new WHATSAPP();
    }

}