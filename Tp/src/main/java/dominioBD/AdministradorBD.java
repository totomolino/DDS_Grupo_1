package dominioBD;

import javax.persistence.*;

@Table(name = "administrador_bd")
@Entity
public class AdministradorBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_id;


    @ManyToOne
    @JoinColumn (name = "id_org")
    private OrganizacionBD admin_organizacion;

    @OneToOne
    private UsuarioBD admin_usuario;


    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public OrganizacionBD getAdmin_organizacion() {
        return admin_organizacion;
    }

    public void setAdmin_organizacion(OrganizacionBD organizacion) {
        this.admin_organizacion = organizacion;
    }

    public UsuarioBD getUsuario() {
        return admin_usuario;
    }

    public void setUsuario(UsuarioBD usuario) {
        this.admin_usuario = usuario;
    }
}