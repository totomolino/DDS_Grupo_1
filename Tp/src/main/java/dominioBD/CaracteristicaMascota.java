package dominioBD;

import javax.persistence.*;
import java.util.List;

@Table(name = "caracteristica_mascota")
@Entity
public class CaracteristicaMascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carmas_id;

    @OneToMany(mappedBy = "carMasMas_carmas")
    List<CarMasXMas>carMasXMas;

    private String carmas_clave;

    public Long getComo_id() {
        return carmas_id;
    }

    public void setComo_id(Long como_id) {
        this.carmas_id = como_id;
    }

    public List<CarMasXMas> getCarMasXMas() {
        return carMasXMas;
    }

    public void setCarMasXMas(List<CarMasXMas> carMasXMas) {
        this.carMasXMas = carMasXMas;
    }

    public String getClave() {
        return carmas_clave;
    }

    public void setClave(String carmas_clave) {
        this.carmas_clave = carmas_clave;
    }
}