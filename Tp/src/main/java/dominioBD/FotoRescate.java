package dominioBD;

import javax.persistence.*;

@Table(name = "foto_rescate")
@Entity
public class FotoRescate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fore_id;

    @ManyToOne
    @JoinColumn(name = "resc_id")
    private RescateBD fore_rescate;

    @Column(columnDefinition="longtext")
    private String fore_direccion;

    public Long getFore_id() {
        return fore_id;
    }

    public void setFore_id(Long fore_id) {
        this.fore_id = fore_id;
    }

    public RescateBD getFore_rescate() {
        return fore_rescate;
    }

    public void setFore_rescate(RescateBD fore_rescate) {
        this.fore_rescate = fore_rescate;
    }

    public String getFore_direccion() {
        return fore_direccion;
    }

    public void setFore_direccion(String fore_direccion) {
        this.fore_direccion = fore_direccion;
    }
}