package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "adoptante_bd")
@Entity
public class AdoptanteBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adop_id;

    @OneToMany (mappedBy = "adoptante_bd")
    private List<ComodidadesXadoptante> comodidades;

}