package dominioBD;

import javax.persistence.*;
import java.util.List;

//@Table(name = "rescatista_bd")
@Entity
public class RescatistaBD extends PersonaBD {

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resc_id;*/


    @OneToMany(mappedBy = "resc_rescatista")
    private List<RescateBD>rescateBDS;

    @ManyToOne
    @JoinColumn(name = "orga_id")
    private OrganizacionBD resc_organizacion;


    //TODO falta agregarle el duenio


   /* public Long getResc_id() {
        return resc_id;
    }

    public void setResc_id(Long resc_id) {
        this.resc_id = resc_id;
    }*/

    public List<RescateBD> getRescateBDS() {
        return rescateBDS;
    }

    public void setRescateBDS(List<RescateBD> rescateBDS) {
        this.rescateBDS = rescateBDS;
    }

    public OrganizacionBD getResc_organizacion() {
        return resc_organizacion;
    }

    public void setResc_organizacion(OrganizacionBD resc_organizacion) {
        this.resc_organizacion = resc_organizacion;
    }
}