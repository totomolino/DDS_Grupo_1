package dominioBD;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Table(name = "organizacion")
@Entity
public class OrganizacionBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orga_id;

    private float orga_posX;
    private float orga_posY;

    @OneToMany(mappedBy = "due_organizacion")
    private List<DuenioBD>duenioBDS;

    @OneToMany(mappedBy = "caor_organizacion")
    private List<CaracteristicaOrg> caracteristicaOrgs;

    @OneToMany(mappedBy = "preg_org")
    private List<PreguntaOrg>preguntaOrgs;

    @OneToMany(mappedBy = "masc_organizacion")
    private List<MascotaBD>mascotaBDS;

    @OneToMany(mappedBy = "admin_organizacion")
    private List<AdministradorBD> administradorBDS;

    //@OneToMany(mappedBy = "")//preguntas obligatorias

    @OneToMany(mappedBy = "volu_organizacion")
    private List<VoluntarioBD> voluntarioBDS;

    @OneToMany(mappedBy = "publ_organizacion")
    List<PublicacionBD> publicacionBDS;

    public Long getOrga_id() {
        return orga_id;
    }

    public void setOrga_id(Long orga_id) {
        this.orga_id = orga_id;
    }

    public float getOrga_posX() {
        return orga_posX;
    }

    public void setOrga_posX(float orga_posX) {
        this.orga_posX = orga_posX;
    }

    public float getOrga_posY() {
        return orga_posY;
    }

    public void setOrga_posY(float orga_posY) {
        this.orga_posY = orga_posY;
    }

    public List<DuenioBD> getDuenioBDS() {
        return duenioBDS;
    }

    public void setDuenioBDS(List<DuenioBD> duenioBDS) {
        this.duenioBDS = duenioBDS;
    }

    public List<CaracteristicaOrg> getCaracteristicaOrgs() {
        return caracteristicaOrgs;
    }

    public void setCaracteristicaOrgs(List<CaracteristicaOrg> caracteristicaOrgs) {
        this.caracteristicaOrgs = caracteristicaOrgs;
    }

    public List<PreguntaOrg> getPreguntaOrgs() {
        return preguntaOrgs;
    }

    public void setPreguntaOrgs(List<PreguntaOrg> preguntaOrgs) {
        this.preguntaOrgs = preguntaOrgs;
    }

    public List<MascotaBD> getMascotaBDS() {
        return mascotaBDS;
    }

    public void setMascotaBDS(List<MascotaBD> mascotaBDS) {
        this.mascotaBDS = mascotaBDS;
    }

    public List<AdministradorBD> getAdministradorBDS() {
        return administradorBDS;
    }

    public void setAdministradorBDS(List<AdministradorBD> administradorBDS) {
        this.administradorBDS = administradorBDS;
    }

    public List<VoluntarioBD> getVoluntarioBDS() {
        return voluntarioBDS;
    }

    public void setVoluntarioBDS(List<VoluntarioBD> voluntarioBDS) {
        this.voluntarioBDS = voluntarioBDS;
    }
}
