package dominioBD;

import javax.persistence.*;

@Table(name = "preg_org_xmascota")
@Entity
public class PregOrgXmascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pregOrg_id;

    @ManyToOne
    @JoinColumn(name = "")
    private Long pregOrg_pregId;

    private Long pregOrg_mascota;

    private String pregOrg_valor;

}