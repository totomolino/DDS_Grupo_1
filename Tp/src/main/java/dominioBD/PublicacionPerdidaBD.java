package dominioBD;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class PublicacionPerdidaBD extends PublicacionBD{

    @OneToOne
    private RescateBD pper_rescate;

    @OneToOne
    private RescatistaBD pper_rescatista;

    @ManyToOne

    public RescateBD getPper_rescate() {
        return pper_rescate;
    }

    public void setPper_rescate(RescateBD pper_rescate) {
        this.pper_rescate = pper_rescate;
    }

    public RescatistaBD getPper_rescatista() {
        return pper_rescatista;
    }

    public void setPper_rescatista(RescatistaBD pper_rescatista) {
        this.pper_rescatista = pper_rescatista;
    }
}
