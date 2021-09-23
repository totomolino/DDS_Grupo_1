package dominioBD;

import javax.persistence.*;

@Table(name = "persona")
@Entity
public class PersonaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pers_id;
    private String pers_nombre;
    private String pers_apellido;
    private String pers_fechaNacimiento;
    private int pers_documento;
    private String pers_tipoDocumento;
    private int pers_idUsuario;
    private String pers_telefono;




}
