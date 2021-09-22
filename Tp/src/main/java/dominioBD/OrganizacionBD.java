package dominioBD;

import javax.persistence.*;

@Table(name = "organizacion")
@Entity
public class OrganizacionBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long org_id;
    private Long org_sistema_id;
    //private Long org_id; // mascotas
    //private Long org_id; //duenios
    //private Long org_id; //administradores
    private Long org_carac; //caracteristicas
    private float org_posX;
    private float org_posY;
    //private Long org_id; //lista de publicaciones
    //private Long org_id; //lista de publicaciones aprobadas
    //private Long org_id; // preguntasOrganizacion



}
