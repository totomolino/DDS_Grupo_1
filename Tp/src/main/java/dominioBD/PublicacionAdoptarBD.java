package dominioBD;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PublicacionAdoptarBD extends PublicacionBD{

    @OneToOne
    private AdoptanteBD padop_adoptante;

    public AdoptanteBD getPadop_adoptante() {
        return padop_adoptante;
    }

    public void setPadop_adoptante(AdoptanteBD padop_adoptante) {
        this.padop_adoptante = padop_adoptante;
    }
}
