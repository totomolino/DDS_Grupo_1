package dominioBD;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

@Table(name = "organizacion")
@Entity
public class OrganizacionBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long org_id;

    @OneToMany(mappedBy = "organizacion")
    private List<MascotaBD> org_mascotas; // mascotas

    //private Long org_id; //duenios
    //private Long org_id; //administradores

    @OneToMany(mappedBy = "organizacion")
    private List<CaracteristicaOrg> caracteristicas;

    @OneToMany(mappedBy = "organizacion")
    private List<PreguntaOrg> preguntas;

    private float org_posX;
    private float org_posY;
    //private Long org_id; //lista de publicaciones
    //private Long org_id; //lista de publicaciones aprobadas
    //private Long org_id; // preguntasOrganizacion



}
