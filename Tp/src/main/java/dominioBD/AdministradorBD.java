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

}