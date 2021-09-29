package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "ComodidadesBD")
@Entity
public class ComodidadesBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long como_id;

    private String como_clave;


    @OneToMany(mappedBy = "comoXad_como")
    private List<ComodidadesXadoptante> comodidadesXadoptantes;

    public Long getComo_id() {
        return como_id;
    }

    public void setComo_id(Long como_id) {
        this.como_id = como_id;
    }

    public String getComo_clave() {
        return como_clave;
    }

    public void setComo_clave(String como_clave) {
        this.como_clave = como_clave;
    }

    public List<ComodidadesXadoptante> getComodidadesXadoptantes() {
        return comodidadesXadoptantes;
    }

    public void setComodidadesXadoptantes(List<ComodidadesXadoptante> comodidadesXadoptantes) {
        this.comodidadesXadoptantes = comodidadesXadoptantes;
    }
}