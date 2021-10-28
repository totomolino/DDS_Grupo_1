package dominioBD;

import Business.Duenio;
import Business.Mascota;
import Business.publicaciones.PublicacionDarEnAdopcion;
import com.fasterxml.jackson.databind.node.ObjectNode;
import utils.BDUtils;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class PublicacionDarEnAdopcionBD extends PublicacionBD{

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

    public PublicacionDarEnAdopcion transformar() {
        Long id = getPubl_id();
        Duenio duenio = this.pdar_duenio.transformar();
        Mascota mascota = this.pdar_mascota.transformar();
        HashMap<String,String> preguntas  = BDUtils.dameHashPreguntasPubli(id);
        PublicacionDarEnAdopcion publicacion = new PublicacionDarEnAdopcion(id,mascota,duenio,preguntas);
        return publicacion;
    }


}
