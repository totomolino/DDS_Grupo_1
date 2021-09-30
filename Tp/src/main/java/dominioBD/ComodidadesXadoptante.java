package dominioBD;

import javax.persistence.*;


@Table(name = "comodidades_xadoptante")
@Entity
public class ComodidadesXadoptante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comoXado_id;

    @ManyToOne
    @JoinColumn(name = "como_id")
    private ComodidadesBD comoXad_como;


    @ManyToOne
    @JoinColumn(name = "pers_id")
    private AdoptanteBD comoXad_adoptante;

    private String comXado_valor;

    public Long getComoXado_id() {
        return comoXado_id;
    }

    public void setComoXado_id(Long comoXado_id) {
        this.comoXado_id = comoXado_id;
    }

    public ComodidadesBD getComoXad_como() {
        return comoXad_como;
    }

    public void setComoXad_como(ComodidadesBD comoXad_como) {
        this.comoXad_como = comoXad_como;
    }

    public AdoptanteBD getComoXad_adoptante() {
        return comoXad_adoptante;
    }

    public void setComoXad_adoptante(AdoptanteBD comoXad_adoptante) {
        this.comoXad_adoptante = comoXad_adoptante;
    }

    public String getComXado_valor() {
        return comXado_valor;
    }

    public void setComXado_valor(String comXado_valor) {
        this.comXado_valor = comXado_valor;
    }
}