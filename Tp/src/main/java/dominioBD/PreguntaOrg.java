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
    private OrganizacionBD organizacion;

    @OneToMany (mappedBy = "pregOrg_pregId")
    List<PregOrgXmascota>pregOrgXmascotas;

    private String clave;

}