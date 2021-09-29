package dominioBD;

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
}