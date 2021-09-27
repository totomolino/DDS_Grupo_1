package dominioBD;

import javax.persistence.*;

@Table(name = "comodidades_xadoptante")
@Entity
public class ComodidadesXadoptante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comoXad_id;

    @ManyToOne
    @JoinColumn(name = "como_id")
    private ComodidadesBD comoXad_comoid;


    @ManyToOne
    @JoinColumn(name = "adop_id")
    private AdoptanteBD comoXad_adoptante;

    public AdoptanteBD getAdoptante_bd() {
        return comoXad_adoptante;
    }

    public void setAdoptante_bd(AdoptanteBD adoptante_bd) {
        this.comoXad_adoptante = adoptante_bd;
    }
}