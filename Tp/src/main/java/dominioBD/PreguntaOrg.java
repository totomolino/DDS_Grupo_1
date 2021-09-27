package dominioBD;

import javax.persistence.*;

@Table(name = "pregunta_org")
@Entity
public class PreguntaOrg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preg_id;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizacionBD organizacion;

    private String clave;

}