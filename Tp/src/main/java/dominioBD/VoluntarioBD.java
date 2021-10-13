package dominioBD;



import javax.persistence.*;
import java.util.List;

@Table(name = "voluntario_bd")
@Entity
public class VoluntarioBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long volu_id;

    private int volu_tamFotos;

    @ManyToOne
    @JoinColumn(name = "orga_id")
    private OrganizacionBD volu_organizacion;

    @OneToOne
    private UsuarioBD volu_usuario;

    @OneToMany
    List<PublicacionPerdidaBD> volu_publicacionesPerdidas;


    public Long getVolu_id() {
        return volu_id;
    }

    public void setVolu_id(Long volu_id) {
        this.volu_id = volu_id;
    }

    public int getVolu_tamFotos() {
        return volu_tamFotos;
    }

    public void setVolu_tamFotos(int volu_tamFotos) {
        this.volu_tamFotos = volu_tamFotos;
    }

    public OrganizacionBD getVolu_organizacion() {
        return volu_organizacion;
    }

    public void setVolu_organizacion(OrganizacionBD volu_organizacion) {
        this.volu_organizacion = volu_organizacion;
    }

    public UsuarioBD getVolu_usuario() {
        return volu_usuario;
    }

    public void setVolu_usuario(UsuarioBD volu_usuario) {
        this.volu_usuario = volu_usuario;
    }
}