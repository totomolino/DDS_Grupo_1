package dominioBD;

import javax.persistence.*;
import java.util.List;

@Entity
public class DuenioBD extends PersonaBD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long due_id;

    @ManyToOne
    @JoinColumn(name = "orga_id")
    private OrganizacionBD due_organizacion;

    @OneToMany(mappedBy = "masc_duenio")
    private List<MascotaBD> mascotas;


}