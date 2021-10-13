package dominioBD;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PublicacionBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publ_id;

    @ManyToOne
    @JoinColumn(name = "orga_id")
    private OrganizacionBD publ_organizacion;

    private String publ_estado;

    public Long getPubl_id() {
        return publ_id;
    }

    public void setPubl_id(Long publ_id) {
        this.publ_id = publ_id;
    }

    public OrganizacionBD getPubl_organizacion() {
        return publ_organizacion;
    }

    public void setPubl_organizacion(OrganizacionBD publ_organizacion) {
        this.publ_organizacion = publ_organizacion;
    }

    public String getPubl_estado() {
        return publ_estado;
    }

    public void setPubl_estado(String publ_estado) {
        this.publ_estado = publ_estado;
    }
}
