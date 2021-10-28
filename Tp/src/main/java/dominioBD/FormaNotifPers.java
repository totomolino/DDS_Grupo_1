package dominioBD;

import Notificar.EMAIL;
import Notificar.SMS;
import Notificar.WHATSAPP;
import Notificar.notificarStrategy;

import javax.persistence.*;

@Table(name = "forma_notif_pers")
@Entity
public class FormaNotifPers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fonop_id;

    @ManyToOne
    @JoinColumn(name = "pers_id")
    private PersonaBD fonop_persona;

    private String fonop_forma;

    public Long getFonop_id() {
        return fonop_id;
    }

    public void setFonop_id(Long fonop_id) {
        this.fonop_id = fonop_id;
    }

    public PersonaBD getFonop_persona() {
        return fonop_persona;
    }

    public void setFonop_persona(PersonaBD fonop_persona) {
        this.fonop_persona = fonop_persona;
    }

    public String getFonop_forma() {
        return fonop_forma;
    }

    public void setFonop_forma(String fonop_forma) {
        this.fonop_forma = fonop_forma;
    }

    public notificarStrategy transformar() {
        if(fonop_forma.equalsIgnoreCase("SMS"))
            return new SMS();
        else if(fonop_forma.equalsIgnoreCase("EMAIL"))
            return new EMAIL();
        else
            return new WHATSAPP();
    }
}