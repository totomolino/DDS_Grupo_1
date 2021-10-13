package dominioBD;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PublicacionDarEnAdopcion extends PublicacionBD{

    @OneToOne
    private MascotaBD pdar_mascota;

    @OneToOne
    private DuenioBD pdar_duenio;

    public MascotaBD getPdar_mascota() {
        return pdar_mascota;
    }

    public void setPdar_mascota(MascotaBD pdar_mascota) {
        this.pdar_mascota = pdar_mascota;
    }

    public DuenioBD getPdar_duenio() {
        return pdar_duenio;
    }

    public void setPdar_duenio(DuenioBD pdar_duenio) {
        this.pdar_duenio = pdar_duenio;
    }
}
