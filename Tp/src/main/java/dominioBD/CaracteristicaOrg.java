package dominioBD;

import javax.persistence.*;

@Table(name = "caracteristica_org")
@Entity
public class CaracteristicaOrg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carac_id;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizacionBD organizacion;

    private String clave;
    private String valor;

}