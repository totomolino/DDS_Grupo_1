package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "persona")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PersonaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pers_id;

    private String pers_nombre;
    private String pers_apellido;
    private String pers_fechaNacimiento;
    private int pers_documento;
    private String pers_tipoDocumento;
    private String pers_telefono;


    @OneToOne
    private UsuarioBD pers_usuario;


    @OneToMany(mappedBy = "cont_persona")
    private List<ContactoBD>contactoBDS;

    @OneToMany(mappedBy = "fonop_persona")
    private List<FormaNotifPers>formaNotifPers;

}
