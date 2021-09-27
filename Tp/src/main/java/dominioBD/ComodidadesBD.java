package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "comodidades_bd")
@Entity
public class ComodidadesBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long como_id;

    private String como_clave;


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

    @OneToMany(mappedBy = "ComodidadesBD")
    private List<ComodidadesXadoptante> mascotas;
}