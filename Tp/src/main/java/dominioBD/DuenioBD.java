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

    public OrganizacionBD getDue_organizacion() {
        return due_organizacion;
    }

    public void setDue_organizacion(OrganizacionBD due_organizacion) {
        this.due_organizacion = due_organizacion;
    }

    public List<MascotaBD> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaBD> mascotas) {
        this.mascotas = mascotas;
    }
}