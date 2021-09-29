package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "caracteristica_org")
@Entity
public class CaracteristicaOrg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caor_id;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizacionBD caor_organizacion;

    @OneToMany(mappedBy = "caorXmas_caor")
    List<CaracOrgXmascota>caracOrgXmascotas;

    private String clave;

    public Long getCaor_id() {
        return caor_id;
    }

    public void setCaor_id(Long caor_id) {
        this.caor_id = caor_id;
    }

    public OrganizacionBD getCaor_organizacion() {
        return caor_organizacion;
    }

    public void setCaor_organizacion(OrganizacionBD caor_organizacion) {
        this.caor_organizacion = caor_organizacion;
    }

    public List<CaracOrgXmascota> getCaracOrgXmascotas() {
        return caracOrgXmascotas;
    }

    public void setCaracOrgXmascotas(List<CaracOrgXmascota> caracOrgXmascotas) {
        this.caracOrgXmascotas = caracOrgXmascotas;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}