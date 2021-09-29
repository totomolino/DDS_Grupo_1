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
    private OrganizacionBD organizacion;

    @OneToOne
    @JoinColumn (name="name id_usuario")
    private UsuarioBD usuario;


    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public OrganizacionBD getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizacionBD organizacion) {
        this.organizacion = organizacion;
    }

    public UsuarioBD getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBD usuario) {
        this.usuario = usuario;
    }
}