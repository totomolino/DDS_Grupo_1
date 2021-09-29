package dominioBD;

import javax.persistence.*;

@Table(name = "preg_org_xmascota")
@Entity
public class PregOrgXmascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pregOrg_id;

    @ManyToOne
    @JoinColumn(name = "preg_id")
    private PreguntaOrg pregOrg_pregId;


    @ManyToOne
    @JoinColumn(name = "masc_id")
    private MascotaBD pregOrg_mascota;

    private String pregOrg_valor;

    public Long getPregOrg_id() {
        return pregOrg_id;
    }

    public void setPregOrg_id(Long pregOrg_id) {
        this.pregOrg_id = pregOrg_id;
    }

    public PreguntaOrg getPregOrg_pregId() {
        return pregOrg_pregId;
    }

    public void setPregOrg_pregId(PreguntaOrg pregOrg_pregId) {
        this.pregOrg_pregId = pregOrg_pregId;
    }

    public MascotaBD getPregOrg_mascota() {
        return pregOrg_mascota;
    }

    public void setPregOrg_mascota(MascotaBD pregOrg_mascota) {
        this.pregOrg_mascota = pregOrg_mascota;
    }

    public String getPregOrg_valor() {
        return pregOrg_valor;
    }

    public void setPregOrg_valor(String pregOrg_valor) {
        this.pregOrg_valor = pregOrg_valor;
    }
}