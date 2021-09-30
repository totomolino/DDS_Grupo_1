package dominioBD;

import javax.persistence.*;
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
}