package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "pregunta_org")
@Entity
public class PreguntaOrg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preg_id;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizacionBD preg_org;

    @OneToMany (mappedBy = "pregOrg_pregId")
    List<PregOrgXmascota>pregOrgXmascotas;

    private String clave;

    public Long getPreg_id() {
        return preg_id;
    }

    public void setPreg_id(Long preg_id) {
        this.preg_id = preg_id;
    }

    public OrganizacionBD getPreg_org() {
        return preg_org;
    }

    public void setPreg_org(OrganizacionBD preg_org) {
        this.preg_org = preg_org;
    }

    public List<PregOrgXmascota> getPregOrgXmascotas() {
        return pregOrgXmascotas;
    }

    public void setPregOrgXmascotas(List<PregOrgXmascota> pregOrgXmascotas) {
        this.pregOrgXmascotas = pregOrgXmascotas;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}